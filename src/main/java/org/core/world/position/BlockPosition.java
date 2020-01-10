package org.core.world.position;

import org.core.vector.Vector3;
import org.core.vector.types.Vector3Int;
import org.core.world.direction.Direction;

public interface BlockPosition extends Position<Integer> {

    @Override
    Vector3Int getPosition();

    @Override
    default BlockPosition getRelative(Vector3<Integer> vector){
        return (BlockPosition) Position.super.getRelative(vector);
    }

    @Override
    default BlockPosition getRelative(Vector3Int vector){
        return (BlockPosition) Position.super.getRelative(vector);
    }

    @Override
    default BlockPosition getRelative(Direction direction){
        return (BlockPosition) Position.super.getRelative(direction.getAsVector());
    }

    default ExactPosition toExactPosition(){
        return getWorld().getPosition((double)getX(), (double)getY(), (double)getZ());
    }
}
