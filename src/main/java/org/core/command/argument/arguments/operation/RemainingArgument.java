package org.core.command.argument.arguments.operation;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;
import org.core.exceptions.NotEnoughArguments;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemainingArgument<T> implements CommandArgument<List<T>> {

    private final String id;
    private final List<CommandArgument<T>> argument;

    @Deprecated
    public RemainingArgument(String id) {
        throw new RuntimeException("Remaining Argument requires at least 1 argument");
    }

    public RemainingArgument(CommandArgument<T> argument) {
        this(argument.getId(), argument);
    }

    @SafeVarargs
    public RemainingArgument(String id, CommandArgument<T>... argument) {
        this(id, Arrays.asList(argument));
    }

    public RemainingArgument(String id, Collection<CommandArgument<T>> argument) {
        if (argument.isEmpty()) {
            throw new IllegalArgumentException("Remaining Argument cannot have a argument of empty");
        }
        this.id = id;
        this.argument = new ArrayList<>(argument);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public CommandArgumentResult<List<T>> parse(CommandContext context, CommandArgumentContext<List<T>> argument) throws IOException {
        int index = argument.getFirstArgument();
        List<T> list = new ArrayList<>();
        while (index < context.getCommand().length) {
            CommandArgumentResult<T> entry = this.parseAny(context, index);
            index = entry.getPosition();
            list.add(entry.getValue());
        }
        return new CommandArgumentResult<>(index, list);
    }

    private CommandArgumentResult<T> parseAny(CommandContext context, int commandIndex) throws IOException {
        IOException e1 = null;
        for (int index = 0; index < this.argument.size(); index++) {
            try {
                CommandArgumentContext<T> argumentContext = new CommandArgumentContext<>(this.argument.get(index), commandIndex, context.getCommand());
                return this.argument.get(index).parse(context, argumentContext);
            } catch (IOException e) {
                if (index == 0) {
                    e1 = e;
                }
            }
        }
        if (e1 == null) {
            //shouldnt be possible
            throw new IOException("Unknown error occurred");
        }
        throw e1;
    }

    @Override
    public Set<String> suggest(CommandContext context, CommandArgumentContext<List<T>> argument) throws NotEnoughArguments {
        int index = argument.getFirstArgument();
        while (index < context.getCommand().length) {
            final int finalIndex = index;
            CommandArgumentResult<T> entry;
            try {
                entry = this.parseAny(context, index);
            } catch (IOException e) {
                return this.argument.stream().flatMap(a -> {
                    try {
                        return a.suggest(context, new CommandArgumentContext<>(a, finalIndex, context.getCommand())).stream();
                    } catch (NotEnoughArguments ex) {
                        return Stream.empty();
                    }
                }).collect(Collectors.toSet());
            }
            index = entry.getPosition();
        }
        return Collections.emptySet();
    }
}
