package org.core.command.argument;

import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;

import java.util.Collection;

public interface SuggestCommandArgument<T> {

    Collection<String> suggest(CommandContext commandContext, CommandArgumentContext<T> argument);

}
