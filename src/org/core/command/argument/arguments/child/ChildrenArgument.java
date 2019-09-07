package org.core.command.argument.arguments.child;

import org.core.CorePlugin;
import org.core.command.BaseCommandLauncher;
import org.core.command.ChildArgumentCommandLauncher;
import org.core.command.argument.ArgumentContext;
import org.core.command.argument.CommandContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChildrenArgument implements ArgumentContext<String> {

    public static class Builder {

        private Map<String, BaseCommandLauncher> children = new HashMap<>();

        public ChildrenArgument build(){
            return new ChildrenArgument(this.children);
        }

        public Builder register(String childName, BaseCommandLauncher launcher){
            this.children.put(childName, launcher);
            return this;
        }
    }

    Map<String, BaseCommandLauncher> children;

    public ChildrenArgument(Map<String, BaseCommandLauncher> map){
        this.children = map;
    }

    public Map<String, BaseCommandLauncher> getChildren(){
        return this.children;
    }

    @Override
    public String parse(CommandContext context) throws IOException {
        String arg = context.next();
        String[] remaining = context.getRawArguments();
        remaining = CorePlugin.strip(String.class, 1, remaining.length, remaining);
        while(context.hasNext()){
            context.next();
        }
        BaseCommandLauncher launcher = this.children.get(arg);

        if(launcher == null){
            throw new IOException("Unknown argument");
        }
        if(context.isForTabComplete()) {
            new IOException("Test").printStackTrace();
            if(launcher instanceof ChildArgumentCommandLauncher) {
                CommandContext context2 = new CommandContext(context.getSource(), ((ChildArgumentCommandLauncher) launcher).getArgumentProcessors(), remaining);
                context2.validate();
            }
        }else{
            launcher.run(context.getSource(), remaining);
        }
        return arg;
    }

    @Override
    public List<String> getSuggestions(CommandContext context, String... args) {
        if(args.length == 0 || (args.length == 1 && args[0].equals(""))){
            return new ArrayList<>(this.children.keySet());
        }else if(args.length == 1){
            return this.children.keySet().stream().filter(s -> s.startsWith(args[0])).collect(Collectors.toList());
        }else{
            String[] args2 = CorePlugin.strip(String.class, 1, args.length, args);
            return this.children.get(args[0]).tab(context.getSource(), args2);
        }
    }

    @Override
    public String getId() {
        return CorePlugin.toString("/", this.children.keySet());
    }
}
