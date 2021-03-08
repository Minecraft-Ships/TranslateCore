package org.core.command.argument.arguments.position;

import org.core.command.argument.arguments.CommandArgument;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;
import org.core.world.WorldExtent;
import org.core.world.position.impl.ExactPosition;
import org.core.world.position.impl.Position;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class PositionArgument<N extends Number, P extends Position<N>> implements CommandArgument<P> {

    private final String id;
    private final CommandArgument<N> positionArgument;

    public PositionArgument(String id, CommandArgument<N> argument){
        this.id = id;
        this.positionArgument = argument;
    }

    public abstract P build(WorldExtent extent, N x, N y, N z);

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Map.Entry<P, Integer> parse(CommandContext context, CommandArgumentContext<P> argument) throws IOException {
        int firstPosition = argument.getFirstArgument();
        WorldArgument worldArg = new WorldArgument("");
        Map.Entry<WorldExtent, Integer> extent = worldArg.parse(context, new CommandArgumentContext<>(worldArg, firstPosition, context.getCommand()));
        Map.Entry<N, Integer> x = this.positionArgument.parse(context, new CommandArgumentContext<>(this.positionArgument, extent.getValue() + 1, context.getCommand()));
        Map.Entry<N, Integer> y = this.positionArgument.parse(context, new CommandArgumentContext<>(this.positionArgument, x.getValue(), context.getCommand()));
        Map.Entry<N, Integer> z = this.positionArgument.parse(context, new CommandArgumentContext<>(this.positionArgument, y.getValue(), context.getCommand()));
        P pos = build(extent.getKey(), x.getKey(), y.getKey(), z.getKey());
        return new AbstractMap.SimpleImmutableEntry<>(pos, z.getValue());
    }

    @Override
    public List<String> suggest(CommandContext commandContext, CommandArgumentContext<P> argument) {
        return Arrays.asList();
    }
}
