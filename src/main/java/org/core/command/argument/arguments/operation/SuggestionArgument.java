package org.core.command.argument.arguments.operation;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.ParseCommandArgument;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;

import java.io.IOException;

public abstract class SuggestionArgument<A> implements CommandArgument<A> {

    protected final ParseCommandArgument<A> argument;
    protected final String id;

    public SuggestionArgument(CommandArgument<A> argument){
        this(argument.getId(), argument);
    }

    public SuggestionArgument(String id, ParseCommandArgument<A> argument) {
        this.argument = argument;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public CommandArgumentResult<A> parse(CommandContext context, CommandArgumentContext<A> argument) throws IOException {
        return this.argument.parse(context, argument);
    }
}
