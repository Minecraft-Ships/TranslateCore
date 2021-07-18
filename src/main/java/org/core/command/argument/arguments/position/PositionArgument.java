package org.core.command.argument.arguments.position;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;
import org.core.world.WorldExtent;
import org.core.world.position.impl.Position;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

public abstract class PositionArgument<N extends Number, P extends Position<N>> implements CommandArgument<P> {

    private final String id;
    private final CommandArgument<N> positionArgument;

    public PositionArgument(String id, CommandArgument<N> argument) {
        this.id = id;
        this.positionArgument = argument;
    }

    public abstract P build(WorldExtent extent, N x, N y, N z);

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public CommandArgumentResult<P> parse(CommandContext context, CommandArgumentContext<P> argument) throws IOException {
        int firstPosition = argument.getFirstArgument();
        WorldArgument worldArg = new WorldArgument("");
        CommandArgumentResult<WorldExtent> extent = worldArg.parse(context, new CommandArgumentContext<>(worldArg, firstPosition, context.getCommand()));
        CommandArgumentResult<N> x = this.positionArgument.parse(context, new CommandArgumentContext<>(this.positionArgument, extent.getPosition() + 1, context.getCommand()));
        CommandArgumentResult<N> y = this.positionArgument.parse(context, new CommandArgumentContext<>(this.positionArgument, x.getPosition(), context.getCommand()));
        CommandArgumentResult<N> z = this.positionArgument.parse(context, new CommandArgumentContext<>(this.positionArgument, y.getPosition(), context.getCommand()));
        P pos = build(extent.getValue(), x.getValue(), y.getValue(), z.getValue());
        return new CommandArgumentResult<>(z.getPosition(), pos);
    }

    @Override
    public Set<String> suggest(CommandContext commandContext, CommandArgumentContext<P> argument) {
        return Collections.emptySet();
    }
}
