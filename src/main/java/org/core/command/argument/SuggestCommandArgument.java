package org.core.command.argument;

import net.kyori.adventure.text.Component;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;
import org.core.exceptions.NotEnoughArguments;

import java.util.Collection;
import java.util.Optional;

public interface SuggestCommandArgument<T> {

    default Optional<Component> errorMessage(CommandContext context, CommandArgumentContext<T> argument) {
        return Optional.empty();
    }

    Collection<String> suggest(CommandContext commandContext, CommandArgumentContext<T> argument)
            throws NotEnoughArguments;

}
