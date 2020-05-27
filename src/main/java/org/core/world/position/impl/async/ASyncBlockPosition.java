package org.core.world.position.impl.async;

import org.core.vector.Vector3;
import org.core.vector.types.Vector3Int;
import org.core.world.direction.Direction;
import org.core.world.position.impl.BlockPosition;

public interface ASyncBlockPosition extends ASyncPosition<Integer>, BlockPosition {

    @Override
    ASyncExactPosition toExactPosition();

    @Override
    Vector3Int getPosition();

    @Override
    default ASyncBlockPosition getRelative(Vector3<Integer> vector){
        return (ASyncBlockPosition) ASyncPosition.super.getRelative(vector);
    }

    @Override
    default ASyncBlockPosition getRelative(Vector3Int vector){
        return (ASyncBlockPosition) ASyncPosition.super.getRelative(vector);
    }

    @Override
    default ASyncBlockPosition getRelative(Direction direction){
        return (ASyncBlockPosition) ASyncPosition.super.getRelative(direction.getAsVector());
    }
}
