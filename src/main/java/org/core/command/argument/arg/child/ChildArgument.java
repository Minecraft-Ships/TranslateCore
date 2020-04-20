package org.core.command.argument.arg.child;

import org.core.CorePlugin;
import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentLauncher;
import org.core.command.argument.CommandContext;
import org.core.source.command.CommandSource;

import java.io.IOException;
import java.util.*;

public abstract class ChildArgument implements CommandArgument<CommandContext.CommandArgumentContext> {

    public static class Arg extends ChildArgument {

        public Arg(String id, CommandArgumentLauncher launcher){
            super(id, launcher);
        }

        public CommandArgumentLauncher getLauncher(){
            return getLaunchers().iterator().next();
        }

        @Override
        public Set<String> getSuggestions(CommandSource source, int index, String... words) {
            String[] strip = CorePlugin.strip(String.class, index, words.length, words);
            return new HashSet<>(this.getLauncher().tab(source, strip));
        }

        @Override
        public ChildContextEntry run(CommandContext context, CommandSource source, int index, String... words) throws IOException {
            CommandContext context1 = new CommandContext(context, this.getLaunchers().iterator().next().getContext());
            CommandContext.CommandArgumentContext output = context1.run(source, words);
            return new ChildContextEntry(this, index, words.length, output, this.getLaunchers().iterator().next());
        }
    }

    private Set<CommandArgumentLauncher> launchers = new HashSet<>();
    private String id;

    public ChildArgument(String id, CommandArgumentLauncher... launchers){
        this(id, Arrays.asList(launchers));
    }

    public ChildArgument(String id, Collection<CommandArgumentLauncher> collection){
        this.launchers.addAll(collection);
        this.id = id;
    }

    public Set<CommandArgumentLauncher> getLaunchers(){
        return this.launchers;
    }

    public Optional<CommandArgumentLauncher> getLauncher(String name){
        return this.launchers.stream().filter(l -> l.getName().equalsIgnoreCase(name)).findFirst();
    }

    @Override
    public String getId() {
        return this.id;
    }

}
