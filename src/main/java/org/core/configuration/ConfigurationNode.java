package org.core.configuration;

import org.core.CorePlugin;
import org.core.configuration.parser.Parser;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ConfigurationNode {

    protected String[] path;

    public ConfigurationNode(ConfigurationNode node, String... path2){
        this(node.getPath(), path2);
    }

    public ConfigurationNode(Object[] path1, Object... path2){
        this(CorePlugin.join(path1, path2));
    }

    public ConfigurationNode(Object... path){
        this.path = new String[path.length];
        for(int A = 0; A < path.length; A++){
            this.path[A] = path[A].toString();
        }
    }

    public boolean contains(ConfigurationNode node){
        for(int A = 0; A < node.path.length; A++){
            String path1 = node.path[A];
            if(A >= this.path.length){
                return false;
            }
            String path2 = this.path[A];
            if(!path1.equals(path2)){
                return false;
            }
        }
        return true;
    }

    public String[] getPath(){
        return this.path;
    }

    public Set<ConfigurationNode> getChildren(ConfigurationFile config){
        return config.getKeyValues().keySet().stream().filter(k -> k.contains(ConfigurationNode.this)).collect(Collectors.toSet());
    }

    public Set<ConfigurationNode> getDirectChildren(ConfigurationFile file){
        int args = this.getPath().length + 1;
        return this.getChildren(file).stream().filter(c -> c.getPath().length == args).collect(Collectors.toSet());
    }

    public <T extends Object> Optional<T> to(ConfigurationFile file, Parser<? extends Object, T> parser){
        return file.parse(this, parser);
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof ConfigurationNode)){
            return false;
        }
        ConfigurationNode node = (ConfigurationNode)obj;
        if(this.getPath().length != node.getPath().length){
            return false;
        }
        for(int A = 0; A < this.getPath().length; A++){
            if(!this.getPath()[A].equals(node.getPath()[A])){
                return false;
            }
        }
        return true;
    }
}
