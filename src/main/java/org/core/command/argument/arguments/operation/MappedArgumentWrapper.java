package org.core.command.argument.arguments.operation;

import org.core.command.argument.arguments.CommandArgument;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class MappedArgumentWrapper<T, J> implements CommandArgument<T> {

    private final CommandArgument<J> commandArgument;
    private final Function<J, T> convert;

    public MappedArgumentWrapper(CommandArgument<J> commandArgument, Function<J, T> convert){
        this.commandArgument = commandArgument;
        this.convert = convert;
    }

    @Override
    public String getId() {
        return this.commandArgument.getId();
    }

    @Override
    public Map.Entry<T, Integer> parse(CommandContext context, CommandArgumentContext<T> argument) throws IOException {
        CommandArgumentContext<J> argContext = new CommandArgumentContext<>(this.commandArgument, argument.getFirstArgument(), context.getCommand());
        Map.Entry<J, Integer> entry = this.commandArgument.parse(context, argContext);
        return new AbstractMap.SimpleImmutableEntry<>(this.convert.apply(entry.getKey()), entry.getValue());
    }

    @Override
    public List<String> suggest(CommandContext context, CommandArgumentContext<T> argument) {
        CommandArgumentContext<J> argContext = new CommandArgumentContext<>(this.commandArgument, argument.getFirstArgument(), context.getCommand());
        return this.commandArgument.suggest(context, argContext);
    }
}
