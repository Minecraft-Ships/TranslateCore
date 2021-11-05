package org.core.command.argument;

import org.core.command.argument.context.CommandContext;
import org.core.permission.Permission;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SingleArgumentCommand<N> implements ArgumentCommand {
    private final CommandArgument<? extends N> numberArgument;
    private final N value;

    public SingleArgumentCommand(N number, CommandArgument<? extends N> argument) {
        this.value = number;
        this.numberArgument = argument;
    }

    @Override
    public List<CommandArgument<?>> getArguments() {
        return Collections.singletonList(this.numberArgument);
    }

    @Override
    public String getDescription() {
        return "Test Description";
    }

    @Override
    public Optional<Permission> getPermissionNode() {
        return Optional.empty();
    }

    @Override
    public boolean run(CommandContext commandContext, String... args) {
        N result = commandContext.getArgument(this, this.numberArgument);
        return result.equals(this.value);
    }
}
