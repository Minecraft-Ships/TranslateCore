package org.core.world.position.impl.async;

import org.core.vector.type.Vector3;
import org.core.world.direction.Direction;
import org.core.world.position.impl.BlockPosition;
import org.core.world.position.impl.sync.SyncExactPosition;

import java.math.BigDecimal;

public interface ASyncBlockPosition extends ASyncPosition<Integer>, BlockPosition {

    @Override
    ASyncExactPosition toExactPosition();

    @Override
    default ASyncBlockPosition getRelative(Vector3<?> vector){
        Vector3<Integer> vector3i = this.getPosition().plus(vector.toVector(BigDecimal::intValue));
        return this.getWorld().getAsyncPosition(vector3i.getX(), vector3i.getY(), vector3i.getZ());
    }

    @Override
    default ASyncBlockPosition getRelative(Direction direction) {
        return this.getRelative(direction.getAsVector());
    }
}
