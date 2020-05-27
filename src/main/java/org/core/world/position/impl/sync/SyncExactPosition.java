package org.core.world.position.impl.sync;

import org.core.vector.Vector3;
import org.core.vector.types.Vector3Double;
import org.core.vector.types.Vector3Int;
import org.core.world.direction.Direction;
import org.core.world.position.impl.ExactPosition;

public interface SyncExactPosition extends SyncPosition<Double>, ExactPosition {

    @Override
    Vector3Double getPosition();

    @Override
    SyncBlockPosition toBlockPosition();

    @Override
    default SyncExactPosition getRelative(Vector3Int vector){
        return getRelative(vector.to(Vector3Double.class));
    }

    @Override
    default SyncExactPosition getRelative(Direction direction){
        return (SyncExactPosition) ExactPosition.super.getRelative(direction);
    }

    @Override
    default SyncExactPosition getRelative(Vector3<Double> vector){
        return (SyncExactPosition) SyncPosition.super.getRelative(vector);
    }
}
