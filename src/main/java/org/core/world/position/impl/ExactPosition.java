package org.core.world.position.impl;

import org.core.world.direction.Direction;

public interface ExactPosition extends Position<Double> {

    BlockPosition toBlockPosition();

    @Override
    ExactPosition getRelative(Direction direction);
}
