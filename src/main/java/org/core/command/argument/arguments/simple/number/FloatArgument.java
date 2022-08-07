package org.core.command.argument.arguments.simple.number;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

public class FloatArgument implements CommandArgument<Float> {

    private final @NotNull String id;

    public FloatArgument(@NotNull String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public CommandArgumentResult<Float> parse(CommandContext context, CommandArgumentContext<Float> argument) throws
            IOException {
        try {
            return CommandArgumentResult.from(argument,
                    Float.parseFloat(context.getCommand()[argument.getFirstArgument()]));
        } catch (NumberFormatException e) {
            throw new IOException("'" + context.getCommand()[argument.getFirstArgument()] + "' is not a number");
        }
    }

    @Override
    public Collection<String> suggest(CommandContext commandContext, CommandArgumentContext<Float> argument) {
        return Collections.emptyList();
    }
}
