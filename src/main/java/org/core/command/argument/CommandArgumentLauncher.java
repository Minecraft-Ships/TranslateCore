package org.core.command.argument;

import org.core.CorePlugin;
import org.core.command.BaseCommandLauncher;
import org.core.command.argument.arg.child.ChildContextEntry;
import org.core.source.command.CommandSource;
import org.core.source.viewer.CommandViewer;

import java.io.IOException;
import java.util.*;

public abstract class CommandArgumentLauncher implements BaseCommandLauncher {

    public static abstract class ChildLauncher extends CommandArgumentLauncher{

        public ChildLauncher(String name, String desc, CommandContext context) {
            super(name, desc, context);
        }

        @Override
        public boolean run(CommandContext.CommandArgumentContext context) {
            Optional<CommandContext.CommandArgumentEntry<?>> opChild = context.getEntries().stream().filter(e -> e instanceof ChildContextEntry).findFirst();
            if(opChild.isPresent()){
                ChildContextEntry entry = (ChildContextEntry) opChild.get();
                CommandArgumentLauncher launcher = entry.getLauncher();
                if(launcher.equals(this)){
                    throw new IllegalStateException("Infinite child loop detected from id: '" + entry.getArgument().getId() + "' in " + this.getClass().getName());
                }
                return launcher.run(context);
            }
            return false;
        }
    }

    public static abstract class MatchLauncher extends ChildLauncher{

        public MatchLauncher(String name, String desc, CommandContext context) {
            super(name, desc, context);
        }

        @Override
        public boolean run(CommandContext.CommandArgumentContext context) {
            Optional<CommandContext.CommandArgumentEntry<?>> opChild = context.getEntries().stream().filter(e -> e instanceof ChildContextEntry).findFirst();
            if(opChild.isPresent()){
                ChildContextEntry entry = (ChildContextEntry) opChild.get();
                CommandArgumentLauncher launcher = entry.getLauncher();
                if(launcher.equals(this)){
                    throw new IllegalStateException("Infinite child loop detected from id: '" + entry.getArgument().getId() + "' in " + this.getClass().getName());
                }
                return launcher.run(context);
            }
            return false;
        }

        @Override
        public boolean run(CommandSource source, String... args){
            try {
                CommandContext.CommandArgumentContext context = this.getContext().run(source, args);
                return this.run(context);
            } catch (IOException e) {
                e.printStackTrace();
                if(source instanceof CommandViewer){
                    ((CommandViewer) source).sendMessagePlain(e.getMessage());
                }
                return false;
            }
        }
    }

    private String name;
    private String desc;
    private CommandContext context;

    public abstract boolean run(CommandContext.CommandArgumentContext context);

    public CommandArgumentLauncher(String name, String desc, CommandContext context){
        this.name = name;
        this.desc = desc;
        this.context = context;
    }

    public CommandContext getContext(){
        return this.context;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.desc;
    }

    @Override
    public boolean run(CommandSource source, String... args){
        try {
            CommandContext.CommandArgumentContext context = this.context.run(source, args);
            return this.run(context);
        } catch (IOException e) {
            e.printStackTrace();
            if(source instanceof CommandViewer){
                ((CommandViewer) source).sendMessagePlain(e.getMessage());
            }
            return false;
        }
    }

    @Override
    public List<String> tab(CommandSource source, String... args) {
        Set<String> unsortedList = this.context.getSuggestions(source, args);
        List<String> list = new ArrayList<>(8);
        Iterator<String> iter = unsortedList.iterator();
        for(int A = 0; A < 8; A++){
            if(iter.hasNext()){
                list.add(iter.next());
            }
        }
        list.sort(Comparator.naturalOrder());
        return list;
    }
}
