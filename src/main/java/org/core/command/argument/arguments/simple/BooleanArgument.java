package org.core.command.argument.arguments.simple;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class BooleanArgument implements CommandArgument<Boolean> {

    private final @NotNull String id;
    private final @NotNull String trueValue;
    private final @NotNull String falseValue;

    public BooleanArgument(@NotNull String id) {
        this(id, "true", "false");
    }

    public BooleanArgument(@NotNull String id, @NotNull String trueValue, @NotNull String falseValue) {
        this.id = id;
        this.trueValue = trueValue;
        this.falseValue = falseValue;

    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public CommandArgumentResult<Boolean> parse(CommandContext context, CommandArgumentContext<Boolean> argument)
            throws IOException {
        String arg = context.getCommand()[argument.getFirstArgument()];
        if (arg.equalsIgnoreCase(this.trueValue)) {
            return CommandArgumentResult.from(argument, true);
        }
        if (arg.equals(this.falseValue)) {
            return CommandArgumentResult.from(argument, false);
        }
        throw new IOException("'" + arg + "' is not either '" + this.trueValue + "' or '" + this.falseValue + "'");
    }

    @Override
    public Set<String> suggest(CommandContext commandContext, CommandArgumentContext<Boolean> argument) {
        String peek = commandContext.getCommand()[argument.getFirstArgument()];
        Set<String> list = new HashSet<>();
        if (this.trueValue.startsWith(peek.toLowerCase())) {
            list.add(this.trueValue);
        }
        if (this.falseValue.startsWith(peek.toLowerCase())) {
            list.add(this.falseValue);
        }
        return list;
    }
}
