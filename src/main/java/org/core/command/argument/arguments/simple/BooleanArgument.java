package org.core.command.argument.arguments.simple;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class BooleanArgument implements CommandArgument<Boolean> {

    private final String id;

    public BooleanArgument(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public CommandArgumentResult<Boolean> parse(CommandContext context, CommandArgumentContext<Boolean> argument) throws IOException {
        String arg = context.getCommand()[argument.getFirstArgument()];
        if (arg.equals("true")) {
            return CommandArgumentResult.from(argument, true);
        }
        if (arg.equals("false")) {
            return CommandArgumentResult.from(argument, false);
        }
        throw new IOException("'" + arg + "' is not either 'true' or 'false'");
    }

    @Override
    public Set<String> suggest(CommandContext commandContext, CommandArgumentContext<Boolean> argument) {
        String peek = commandContext.getCommand()[argument.getFirstArgument()];
        Set<String> list = new HashSet<>();
        if ("true".startsWith(peek.toLowerCase())) {
            list.add("true");
        }
        if ("false".startsWith(peek.toLowerCase())) {
            list.add("false");
        }
        return list;
    }
}
