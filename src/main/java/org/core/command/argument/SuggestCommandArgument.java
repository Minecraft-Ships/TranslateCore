package org.core.command.argument;

import org.core.adventureText.AText;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;
import org.core.exceptions.NotEnoughArguments;

import java.util.Collection;
import java.util.Optional;

public interface SuggestCommandArgument<T> {

    default Optional<AText> errorMessage(CommandContext context, CommandArgumentContext<T> argument) {
        return Optional.empty();
    }

    Collection<String> suggest(CommandContext commandContext, CommandArgumentContext<T> argument) throws NotEnoughArguments;

}
