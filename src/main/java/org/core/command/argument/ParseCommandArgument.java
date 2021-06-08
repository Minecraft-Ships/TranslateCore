package org.core.command.argument;

import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;

import java.io.IOException;

public interface ParseCommandArgument<T> {

    CommandArgumentResult<T> parse(CommandContext context, CommandArgumentContext<T> argument) throws IOException;

}
