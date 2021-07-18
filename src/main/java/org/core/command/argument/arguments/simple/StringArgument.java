package org.core.command.argument.arguments.simple;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

public class StringArgument implements CommandArgument<String> {

    private final String id;

    public StringArgument(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public CommandArgumentResult<String> parse(CommandContext context, CommandArgumentContext<String> argument) throws IOException {
        String text = context.getCommand()[argument.getFirstArgument()];
        return CommandArgumentResult.from(argument, text);

    }

    @Override
    public Set<String> suggest(CommandContext commandContext, CommandArgumentContext<String> argument) {
        return Collections.emptySet();
    }
}
