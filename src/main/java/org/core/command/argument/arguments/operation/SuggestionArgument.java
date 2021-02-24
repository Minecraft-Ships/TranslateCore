package org.core.command.argument.arguments.operation;

import org.core.command.argument.arguments.CommandArgument;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;

import java.io.IOException;
import java.util.Map;

public abstract class SuggestionArgument<A extends Object> implements CommandArgument<A> {

    protected final CommandArgument<A> argument;

    public SuggestionArgument(CommandArgument<A> argument){
        this.argument = argument;
    }
    @Override
    public String getId() {
        return this.argument.getId();
    }

    @Override
    public Map.Entry<A, Integer> parse(CommandContext context, CommandArgumentContext<A> argument) throws IOException {
        return this.argument.parse(context, argument);
    }
}
