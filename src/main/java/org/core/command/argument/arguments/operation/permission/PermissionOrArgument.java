package org.core.command.argument.arguments.operation.permission;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;
import org.core.source.command.CommandSource;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public class PermissionOrArgument<T> implements CommandArgument<T> {

    private final String id;
    private final Predicate<CommandSource> permission;
    private final CommandArgument<T> with;
    private final CommandArgument<T> or;

    public PermissionOrArgument(String id, Predicate<CommandSource> permission, CommandArgument<T> with, CommandArgument<T> or) {
        this.id = id;
        this.permission = permission;
        this.with = with;
        this.or = or;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public CommandArgumentResult<T> parse(CommandContext context, CommandArgumentContext<T> argument) throws IOException {
        if (this.permission.test(context.getSource())) {
            return this.with.parse(context, argument);
        }
        return this.or.parse(context, argument);
    }

    @Override
    public List<String> suggest(CommandContext context, CommandArgumentContext<T> argument) {
        if (this.permission.test(context.getSource())) {
            return this.with.suggest(context, argument);
        }
        return this.or.suggest(context, argument);
    }
}
