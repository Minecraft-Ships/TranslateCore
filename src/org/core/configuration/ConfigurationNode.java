package org.core.configuration;

import org.core.CorePlugin;
import org.core.configuration.parser.Parser;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ConfigurationNode {

    protected String[] path;

    public ConfigurationNode(String[] path1, String... path2){
        this(CorePlugin.join(path1, path2));
    }

    public ConfigurationNode( String... path){
        this.path = path;
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

    public <T extends Object> Optional<T> to(ConfigurationFile file, Parser<? extends Object, T> parser){
        return file.parse(this, parser);
    }
}
