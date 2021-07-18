package org.core.command.argument.arguments.operation;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnyArgument<A> implements CommandArgument<A> {

    private final String id;
    private final Function<A, String> toString;
    private final BiFunction<Collection<A>, String, A> fromString;
    private final BiFunction<CommandContext, CommandArgumentContext<A>, Collection<A>> supply;

    @SafeVarargs
    public AnyArgument(String id, Function<A, String> toString, BiFunction<Collection<A>, String, A> fromString, A... array) {
        this(id, toString, fromString, Arrays.asList(array));
    }

    public AnyArgument(String id, Function<A, String> toString, BiFunction<Collection<A>, String, A> fromString, Collection<A> collection) {
        this(id, toString, fromString, (c, a) -> collection);
    }

    public AnyArgument(String id, Function<A, String> toString, BiFunction<Collection<A>, String, A> fromString, BiFunction<CommandContext, CommandArgumentContext<A>, Collection<A>> supply) {
        this.id = id;
        this.toString = toString;
        this.fromString = fromString;
        this.supply = supply;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public CommandArgumentResult<A> parse(CommandContext context, CommandArgumentContext<A> argument) throws IOException {
        String arg = context.getCommand()[argument.getFirstArgument()];
        A result = this.fromString.apply(this.supply.apply(context, argument), arg);
        if (result == null) {
            throw new IOException("Unknown value of " + arg);
        }
        return CommandArgumentResult.from(argument, 0, result);
    }

    @Override
    public Set<String> suggest(CommandContext context, CommandArgumentContext<A> argument) {
        String arg = context.getCommand()[argument.getFirstArgument()];
        return this.supply.apply(context, argument).stream().map(toString).filter(v -> v.toLowerCase().startsWith(arg)).collect(Collectors.toSet());
    }
}
