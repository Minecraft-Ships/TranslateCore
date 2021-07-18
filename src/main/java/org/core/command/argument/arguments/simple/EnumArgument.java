package org.core.command.argument.arguments.simple;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumArgument<E extends Enum<?>> implements CommandArgument<E> {

    private final String id;
    private final Class<E> clazz;

    public EnumArgument(String id, Class<E> clazz) {
        this.id = id;
        this.clazz = clazz;
    }

    private E[] getValues() throws NoSuchFieldException, IllegalAccessException {
        Field f = this.clazz.getDeclaredField("$VALUES");
        f.setAccessible(true);
        Object o = f.get(null);
        return (E[]) o;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public CommandArgumentResult<E> parse(CommandContext context, CommandArgumentContext<E> argument) throws IOException {
        String next = context.getCommand()[argument.getFirstArgument()];
        try {
            Optional<E> opValue = Stream.of(this.getValues()).filter(n -> n.name().equalsIgnoreCase(next)).findFirst();
            if (opValue.isPresent()) {
                return CommandArgumentResult.from(argument, opValue.get());
            }
            throw new IOException("Unknown value of '" + next + "' in argument " + this.getUsage());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IOException(e);
        }
    }

    @Override
    public Set<String> suggest(CommandContext commandContext, CommandArgumentContext<E> argument) {
        String peek = commandContext.getCommand()[argument.getFirstArgument()];
        try {
            return Stream.of(this.getValues()).map(e -> e.name()).filter(n -> n.startsWith(peek.toUpperCase())).collect(Collectors.toSet());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return Collections.emptySet();
        }
    }
}
