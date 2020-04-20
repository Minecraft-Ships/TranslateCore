package org.core.command.argument.arg.generic.optional;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandContext;
import org.core.source.command.CommandSource;

import java.io.IOException;
import java.util.Set;

public class DefaultArgument<T> implements OptionalArgument<T> {

    private CommandArgument<T> argument;
    private T defaultValue;

    public DefaultArgument(CommandArgument<T> argument, T defaultValue){
        this.argument = argument;
        this.defaultValue = defaultValue;
    }

    @Override
    public Set<String> getSuggestions(CommandSource source, int index, String... words) {
        return this.argument.getSuggestions(source, index, words);
    }

    @Override
    public String getId() {
        return this.argument.getId();
    }

    @Override
    public CommandContext.CommandArgumentEntry<T> run(CommandContext context, CommandSource source, int index, String... words) {
        try {
            return this.argument.run(context, source, index, words);
        } catch (IOException e) {
            return new CommandContext.CommandArgumentEntry<>(this, index, index, this.defaultValue);
        }

    }
}
