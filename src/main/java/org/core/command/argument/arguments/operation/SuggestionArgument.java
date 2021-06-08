package org.core.command.argument.arguments.operation;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;

import java.io.IOException;

public abstract class SuggestionArgument<A> implements CommandArgument<A> {

    protected final CommandArgument<A> argument;

    public SuggestionArgument(CommandArgument<A> argument) {
        this.argument = argument;
    }

    @Override
    public String getId() {
        return this.argument.getId();
    }

    @Override
    public CommandArgumentResult<A> parse(CommandContext context, CommandArgumentContext<A> argument) throws IOException {
        return this.argument.parse(context, argument);
    }
}
