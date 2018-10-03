package org.core.world.position;

import org.core.vector.types.Vector3Int;

public interface BlockPosition extends Position<Integer> {

    @Override
    Vector3Int getPosition();

    default ExactPosition toExactPosition(){
        return getWorld().getPosition((double)getX(), (double)getY(), (double)getZ());
    }
}
