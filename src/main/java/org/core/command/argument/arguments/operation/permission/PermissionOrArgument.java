package org.core.command.argument.arguments.operation.permission;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.ParseCommandArgument;
import org.core.command.argument.SuggestCommandArgument;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;
import org.core.source.command.CommandSource;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Predicate;

/**
 * Allows to provide a better argument to the source if they have the provided permission
 *
 * @param <T> The returning class type
 */
public class PermissionOrArgument<T> implements CommandArgument<T> {

    private final String id;
    private final Predicate<CommandSource> permission;
    private final ParseCommandArgument<T> with;
    private final ParseCommandArgument<T> or;

    /**
     * @param id         The id of the command argument
     * @param permission the check for if the provided command source has permission. If needed this can be checked for other boolean values such as if a player is part of a town
     * @param with       The command argument to use if the user has permission
     * @param or         The command argument to use if the user doesn't have permission
     */
    public PermissionOrArgument(String id, Predicate<CommandSource> permission, ParseCommandArgument<T> with, ParseCommandArgument<T> or) {
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
    public Collection<String> suggest(CommandContext context, CommandArgumentContext<T> argument) {
        if (this.permission.test(context.getSource())) {
            if (this.with instanceof SuggestCommandArgument) {
                return ((SuggestCommandArgument<T>) this.with).suggest(context, argument);
            }
        }
        if (this.or instanceof SuggestCommandArgument) {
            return ((SuggestCommandArgument<T>) this.or).suggest(context, argument);
        }
        return Collections.emptySet();
    }
}
