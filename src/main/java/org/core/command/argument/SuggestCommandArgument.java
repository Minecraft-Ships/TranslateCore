package org.core.command.argument;

import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;
import org.core.exceptions.NotEnoughArguments;

import java.util.Collection;
import java.util.Optional;

public interface SuggestCommandArgument<T> {

    Collection<String> suggest(CommandContext commandContext, CommandArgumentContext<T> argument) throws NotEnoughArguments;

}
