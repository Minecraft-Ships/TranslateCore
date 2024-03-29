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

public class FlatRemainingArgument<T> implements CommandArgument<List<T>> {

    private final String id;
    private final List<CommandArgument<? extends Collection<T>>> argument;

    @Deprecated
    public FlatRemainingArgument(String ignored) {
        throw new RuntimeException("Flat Remaining Argument requires at least one argument");
    }

    public FlatRemainingArgument(CommandArgument<? extends Collection<T>> argument) {
        this(argument.getId(), argument);
    }

    @SafeVarargs
    public FlatRemainingArgument(String id, CommandArgument<? extends Collection<T>>... argument) {
        this(id, Arrays.asList(argument));
    }

    public FlatRemainingArgument(String id, Collection<CommandArgument<? extends Collection<T>>> argument) {
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

    private <R extends Collection<T>> CommandArgumentResult<R> parse(CommandContext context,
                                                                     int commandIndex,
                                                                     CommandArgument<R> argument) throws IOException {
        CommandArgumentContext<R> argumentContext = new CommandArgumentContext<>(argument, commandIndex, context.getCommand());
        return argument.parse(context, argumentContext);
    }

    @Override
    public CommandArgumentResult<List<T>> parse(CommandContext context, CommandArgumentContext<List<T>> argument)
            throws IOException {
        int index = argument.getFirstArgument();
        List<T> list = new ArrayList<>();
        while (index < context.getCommand().length) {
            CommandArgumentResult<? extends Collection<T>> entry = this.parseAny(context, index);
            index = entry.getPosition();
            list.addAll(entry.getValue());
        }
        return new CommandArgumentResult<>(index, list);
    }

    private CommandArgumentResult<? extends Collection<T>> parseAny(CommandContext context, int commandIndex) throws IOException {
        IOException e1 = null;
        for (int index = 0; index < this.argument.size(); index++) {
            try {
                return this.parse(context, commandIndex, this.argument.get(index));
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
    public Set<String> suggest(CommandContext context, CommandArgumentContext<List<T>> argument) {
        int index = argument.getFirstArgument();
        while (index < context.getCommand().length) {
            final int finalIndex = index;
            CommandArgumentResult<? extends Collection<T>> entry;
            try {
                entry = this.parseAny(context, index);
            } catch (IOException e) {
                return this.argument.stream().flatMap(a -> {
                    try {
                        return this.suggest(context, finalIndex, a).stream();
                    } catch (NotEnoughArguments ex) {
                        return Stream.empty();
                    }
                }).collect(Collectors.toSet());
            }
            index = entry.getPosition();
        }
        return Collections.emptySet();
    }

    private <R extends Collection<T>> Collection<String> suggest(CommandContext commandContext, int commandIndex, CommandArgument<R> arg)
            throws NotEnoughArguments {
        CommandArgumentContext<R> argumentContext = new CommandArgumentContext<>(arg, commandIndex, commandContext.getCommand());
        return arg.suggest(commandContext, argumentContext);
    }
}
