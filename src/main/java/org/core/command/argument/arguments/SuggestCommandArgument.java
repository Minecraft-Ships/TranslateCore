package org.core.command.argument.arguments;

import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;

import java.util.List;

public interface SuggestCommandArgument<T> {

    List<String> suggest(CommandContext commandContext, CommandArgumentContext<T> argument);

}
