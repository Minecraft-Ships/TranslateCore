package org.core.command.argument.arg.child;

import org.core.CorePlugin;
import org.core.command.argument.CommandArgumentLauncher;
import org.core.command.argument.CommandContext;
import org.core.source.command.CommandSource;

import java.io.IOException;
import java.util.*;

public class MatchArgument extends ChildArgument {

    private Set<ChildArgument> arguments = new HashSet<>();
    private String id;

    public MatchArgument(String id, ChildArgument... args){
        this(id, Arrays.asList(args));
    }

    public MatchArgument(String id, Collection<ChildArgument> arguments){
        super(id, getLaunchers(arguments));
        this.id = id;
        this.arguments.addAll(arguments);
    }

    @Override
    public Set<String> getSuggestions(CommandSource source, int index, String... words) {
        Set<String> set = new HashSet<>();
        if((index + 1) == words.length){
            this.arguments.stream().filter(c -> c.getId().toLowerCase().startsWith(words[index].toLowerCase())).forEach(c -> set.add(c.getId()));
            return set;
        }
        if(index == words.length){
            this.arguments.stream().forEach(c -> set.add(c.getId()));
            return set;
        }
        Optional<ChildArgument> opArgument = this.arguments.stream().filter(c -> c.getId().equalsIgnoreCase(words[index])).findAny();
        if(!opArgument.isPresent()){
            return set;
        }

        CommandArgumentLauncher launcher = this.getLauncher(words[index]).get();
        return launcher.getContext().getSuggestions(source, CorePlugin.strip(String.class, index + 1, words.length, words));
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public CommandContext.CommandArgumentEntry<CommandContext.CommandArgumentContext> run(CommandContext context, CommandSource source, int index, String... words) throws IOException {
        Optional<ChildArgument> opArgument = this.arguments.stream().filter(c -> c.getId().equalsIgnoreCase(words[index])).findAny();
        if(opArgument.isPresent()){
            String[] stripped = CorePlugin.stripIndexFrom(String.class, words, index);
            return opArgument.get().run(context, source, stripped.length, stripped);
            //return new CommandContext.CommandArgumentEntry<>(this, index, index + 1, null);
        }
        throw new IOException("Unknown argument of " + words[index]);
    }

    private static Set<CommandArgumentLauncher> getLaunchers(Collection<ChildArgument> args){
        Set<CommandArgumentLauncher> set = new HashSet();
        args.stream().forEach(c -> set.addAll(c.getLaunchers()));
        return set;
    }
}
