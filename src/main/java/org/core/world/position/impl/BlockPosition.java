package org.core.world.position.impl;

import org.core.vector.Vector3;
import org.core.vector.types.Vector3Int;
import org.core.world.direction.Direction;
import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.impl.sync.SyncPosition;

public interface BlockPosition extends Position<Integer> {

    ExactPosition toExactPosition();

    @Override
    Vector3Int getPosition();

    BlockPosition getRelative(Vector3<Integer> vector);

    BlockPosition getRelative(Vector3Int vector);

    @Override
    default BlockPosition getRelative(Direction direction){
        return (SyncBlockPosition) Position.super.getRelative(direction);
    }
}
