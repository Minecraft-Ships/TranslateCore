package org.core.world.position.impl;

import org.core.vector.Vector3;
import org.core.vector.types.Vector3Double;
import org.core.vector.types.Vector3Int;
import org.core.world.direction.Direction;

public interface ExactPosition extends Position<Double> {

    BlockPosition toBlockPosition();

    @Override
    Vector3Double getPosition();

    @Override
    ExactPosition getRelative(Vector3<Double> vector);

    @Override
    ExactPosition getRelative(Vector3Int vector);

    @Override
    default ExactPosition getRelative(Direction direction){
        return (ExactPosition) Position.super.getRelative(direction);
    }
}
