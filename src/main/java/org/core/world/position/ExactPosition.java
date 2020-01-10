package org.core.world.position;

import org.core.vector.Vector3;
import org.core.vector.types.Vector3Double;
import org.core.vector.types.Vector3Int;
import org.core.world.direction.Direction;

public interface ExactPosition extends Position<Double> {

    @Override
    Vector3Double getPosition();

    BlockPosition toBlockPosition();

    @Override
    default ExactPosition getRelative(Vector3Int vector){
        return getRelative(vector.to(Vector3Double.class));
    }

    @Override
    default ExactPosition getRelative(Direction direction){
        return (ExactPosition) Position.super.getRelative(direction);
    }

    @Override
    default ExactPosition getRelative(Vector3<Double> vector){
        return (ExactPosition) Position.super.getRelative(vector);
    }
}
