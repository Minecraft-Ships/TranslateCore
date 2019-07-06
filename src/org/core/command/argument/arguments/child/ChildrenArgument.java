package org.core.command.argument.arguments.child;

import org.core.CorePlugin;
import org.core.command.CommandLauncher;
import org.core.command.argument.ArgumentContext;
import org.core.command.argument.CommandContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChildrenArgument implements ArgumentContext<String> {

    Map<String, CommandLauncher> children;

    public ChildrenArgument(Map<String, CommandLauncher> map){
        this.children = map;
    }

    @Override
    public String parse(CommandContext context) throws IOException {
        String arg = context.next();
        List<String> list = new ArrayList<>();
        while(context.hasNext()){
            list.add(context.next());
        }
        this.children.get(arg).tab(context.getSource(), list.toArray(new String[0]));
        return arg;
    }

    @Override
    public List<String> getSuggestions(CommandContext context, String... args) {
        if(args.length == 0 || (args.length == 1 && args[0].equals(""))){
            return new ArrayList<>(this.children.keySet());
        }else if(args.length == 1){
            return this.children.keySet().stream().filter(s -> s.startsWith(args[0])).collect(Collectors.toList());
        }else{
            String[] args2 = new String[args.length];
            for(int A = 1; A < args.length; A++){
                args2[A-1] = args2[A];
            }
            return this.children.get(args[0]).tab(context.getSource(), args2);
        }
    }

    @Override
    public String getId() {
        return CorePlugin.toString("/", this.children.keySet());
    }
}
