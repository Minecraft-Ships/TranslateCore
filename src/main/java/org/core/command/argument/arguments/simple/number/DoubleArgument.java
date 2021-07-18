package org.core.command.argument.arguments.simple.number;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

public class DoubleArgument implements CommandArgument<Double> {

    private final String id;

    public DoubleArgument(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public CommandArgumentResult<Double> parse(CommandContext context, CommandArgumentContext<Double> argument) throws IOException {
        try {
            return CommandArgumentResult.from(argument, Double.parseDouble(context.getCommand()[argument.getFirstArgument()]));
        } catch (NumberFormatException e) {
            throw new IOException("'" + context.getCommand()[argument.getFirstArgument()] + "' is not a number");
        }
    }

    @Override
    public Set<String> suggest(CommandContext commandContext, CommandArgumentContext<Double> argument) {
        return Collections.emptySet();
    }
}
