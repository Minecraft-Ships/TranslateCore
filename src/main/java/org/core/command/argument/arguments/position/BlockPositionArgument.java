package org.core.command.argument.arguments.position;

import org.core.command.argument.arguments.simple.number.IntegerArgument;
import org.core.world.WorldExtent;
import org.core.world.position.impl.BlockPosition;

public class BlockPositionArgument extends PositionArgument<Integer, BlockPosition>{

    public BlockPositionArgument(String id) {
        super(id, new IntegerArgument(""));
    }

    @Override
    public BlockPosition build(WorldExtent extent, Integer x, Integer y, Integer z) {
        return extent.getPosition(x, y, z);
    }
}
