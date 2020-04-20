package org.core.command.argument.arg.generic;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandContext;
import org.core.source.command.CommandSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AnyAmountArgument<T> implements CommandArgument<List<T>> {

    private CommandArgument<T> argument;
    private String id;

    public AnyAmountArgument(String id, CommandArgument<T> argument){
        this.argument = argument;
        this.id = id;
    }

    @Override
    public Set<String> getSuggestions(CommandSource source, int index, String... words) {
        return this.argument.getSuggestions(source, index, words);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public CommandContext.CommandArgumentEntry<List<T>> run(CommandContext context, CommandSource source, int index, String... words) {
        List<T> list = new ArrayList<>();
        for(int A = index; A < words.length; A++){
            try {
                list.add(this.argument.run(context, source, A, words).getValue().get());
            } catch (IOException e) {
                return new CommandContext.CommandArgumentEntry<>(this, index, A, list);
            }
        }
        return new CommandContext.CommandArgumentEntry<>(this, index, index, list);
    }
}
