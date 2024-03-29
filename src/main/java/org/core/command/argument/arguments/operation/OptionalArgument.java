package org.core.command.argument.arguments.operation;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.ParseCommandArgument;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;
import org.core.exceptions.NotEnoughArguments;

import java.io.IOException;
import java.util.Collection;

public class OptionalArgument<T> implements CommandArgument<T> {

    public static class WrappedParser<T> implements ParseCommandArgument<T> {

        private final T value;

        public WrappedParser(T value) {
            this.value = value;
        }

        @Override
        public CommandArgumentResult<T> parse(CommandContext context, CommandArgumentContext<T> argument) {
            return CommandArgumentResult.from(argument, 0, this.value);
        }
    }

    private final CommandArgument<T> arg;
    private final ParseCommandArgument<T> value;

    public OptionalArgument(CommandArgument<T> arg, T value) {
        this(arg, new WrappedParser<>(value));
    }

    public OptionalArgument(CommandArgument<T> arg, ParseCommandArgument<T> value) {
        this.arg = arg;
        this.value = value;
    }

    @Override
    public String getId() {
        return this.arg.getId();
    }

    @Override
    public String getUsage() {
        String original = this.getOriginalArgument().getUsage();
        return "[" + original.substring(1, original.length() - 1) + "]";
    }

    public CommandArgument<T> getOriginalArgument() {
        return this.arg;
    }

    @Override
    public CommandArgumentResult<T> parse(CommandContext context, CommandArgumentContext<T> argument) throws IOException {
        if (context.getCommand().length == argument.getFirstArgument()) {
            if (this.value == null) {
                return CommandArgumentResult.from(argument, 0, null);
            }
            return CommandArgumentResult.from(argument, 0, this.value.parse(context, argument).getValue());
        }
        try {
            return this.arg.parse(context, argument);
        } catch (IOException e) {
            if (this.value == null) {
                return CommandArgumentResult.from(argument, 0, null);
            }
            CommandArgumentResult<T> parsed = this.value.parse(context, argument);
            if (parsed == null) {
                throw new NullPointerException("The parser from " + this.value.getClass().getName() + " returned null");
            }

            return CommandArgumentResult.from(argument, 0, parsed.getValue());
        }
    }

    @Override
    public Collection<String> suggest(CommandContext commandContext, CommandArgumentContext<T> argument) throws NotEnoughArguments {
        return this.arg.suggest(commandContext, argument);
    }
}
