package org.core.command.argument.arguments.position;

import org.core.command.argument.arguments.simple.number.DoubleArgument;
import org.core.world.WorldExtent;
import org.core.world.position.impl.ExactPosition;

public class ExactPositionArgument extends PositionArgument<Double, ExactPosition>{

    public ExactPositionArgument(String id) {
        super(id, new DoubleArgument(""));
    }

    @Override
    public ExactPosition build(WorldExtent extent, Double x, Double y, Double z) {
        return extent.getPosition(x, y, z);
    }
}
