package org.core.command.argument.arguments;

import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;
import org.core.source.command.CommandSource;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CommandArgument <T>{

    String getId();

    Map.Entry<T, Integer> parse(CommandContext context, CommandArgumentContext<T> argument) throws IOException;
    List<String> suggest(CommandContext commandContext, CommandArgumentContext<T> argument);

    default String getUsage(){
        return "<" + this.getId() + ">";
    }


}
