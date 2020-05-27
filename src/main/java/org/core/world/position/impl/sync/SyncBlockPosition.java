package org.core.world.position.impl.sync;

import org.core.vector.Vector3;
import org.core.vector.types.Vector3Int;
import org.core.world.direction.Direction;
import org.core.world.position.impl.BlockPosition;

public interface SyncBlockPosition extends SyncPosition<Integer>, BlockPosition {

    @Override
    default SyncBlockPosition getRelative(Vector3<Integer> vector){
        return (SyncBlockPosition) SyncPosition.super.getRelative(vector);
    }

    @Override
    default SyncBlockPosition getRelative(Vector3Int vector){
        return (SyncBlockPosition) SyncPosition.super.getRelative(vector);
    }

    @Override
    default SyncBlockPosition getRelative(Direction direction){
        return (SyncBlockPosition) SyncPosition.super.getRelative(direction.getAsVector());
    }

    @Override
    default SyncExactPosition toExactPosition(){
        return getWorld().getPosition((double)getX(), (double)getY(), (double)getZ());
    }
}
