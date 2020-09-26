package org.core.world.position.impl.async;

import org.core.vector.Vector3;
import org.core.vector.types.Vector3Double;
import org.core.vector.types.Vector3Int;
import org.core.world.direction.Direction;
import org.core.world.position.impl.ExactPosition;

public interface ASyncExactPosition extends ASyncPosition<Double>, ExactPosition {

    @Override
    ASyncBlockPosition toBlockPosition();

    @Override
    Vector3Double getPosition();

    @Override
    default ASyncExactPosition getRelative(Vector3Int vector){
        return getRelative(vector.to(Vector3Double.class));
    }

    @Override
    default ASyncExactPosition getRelative(Direction direction){
        return (ASyncExactPosition) ExactPosition.super.getRelative(direction);
    }

    @Override
    default ASyncExactPosition getRelative(Vector3<Double> vector){
        return (ASyncExactPosition) ASyncPosition.super.getRelative(vector);
    }
}
