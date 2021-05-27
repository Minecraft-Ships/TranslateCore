package org.core.command.argument.arguments;

import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;

import java.io.IOException;
import java.util.Map;

public interface ParseCommandArgument<T> {

    Map.Entry<T, Integer> parse(CommandContext context, CommandArgumentContext<T> argument) throws IOException;

}
