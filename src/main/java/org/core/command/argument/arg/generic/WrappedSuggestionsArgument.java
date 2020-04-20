package org.core.command.argument.arg.generic;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandContext;
import org.core.source.command.CommandSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class WrappedSuggestionsArgument<T> implements CommandArgument<T> {

    public static class Fixed<T> extends WrappedSuggestionsArgument<T>{

        private Set<String> collection = new HashSet<>();

        public Fixed(CommandArgument<T> argument, String... array){
            this(argument, Arrays.asList(array));
        }

        public Fixed(CommandArgument<T> argument, Collection<String> collection){
            this(argument, (t) -> t, collection);
        }

        public <E> Fixed(CommandArgument<T> cmd, Function<E, String> toString, E... array){
            this(cmd, toString, Arrays.asList(array));
        }

        public <E> Fixed(CommandArgument<T> cmd, Function<E, String> toString, Collection<E> collection) {
            super(cmd);
            collection.forEach(c -> this.collection.add(toString.apply(c)));
        }

        @Override
        public Set<String> getSuggestions(CommandSource source, int index, String... words) {
            return this.collection.stream().filter(c -> c.toLowerCase().startsWith(words[index].toLowerCase())).collect(Collectors.toSet());
        }
    }

    private CommandArgument<T> cmd;

    public WrappedSuggestionsArgument(CommandArgument<T> cmd){
        this.cmd = cmd;
    }

    @Override
    public String getId() {
        return cmd.getId();
    }

    @Override
    public CommandContext.CommandArgumentEntry<T> run(CommandContext context, CommandSource source, int index, String... words) throws IOException {
        return cmd.run(context, source, index, words);
    }
}
