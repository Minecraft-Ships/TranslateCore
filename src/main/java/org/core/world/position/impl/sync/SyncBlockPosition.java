package org.core.world.position.impl.sync;

import org.core.vector.type.Vector3;
import org.core.world.direction.Direction;
import org.core.world.position.impl.BlockPosition;
import org.core.world.position.impl.async.ASyncBlockPosition;

import java.math.BigDecimal;

public interface SyncBlockPosition extends SyncPosition<Integer>, BlockPosition {

    @Override
    @Deprecated
    default SyncBlockPosition toBlockPosition() {
        return this;
    }

    @Override
    @Deprecated
    default SyncBlockPosition toSyncPosition() {
        return this;
    }

    @Override
    @Deprecated(forRemoval = true)
    default ASyncBlockPosition toAsyncPosition() {
        return this.getWorld().getAsyncPosition(this.getX(), this.getY(), this.getZ());
    }


    @Override
    default SyncBlockPosition getRelative(Vector3<?> vector) {
        Vector3<Integer> vector3i = this.getPosition().plus(vector.toVector(BigDecimal::intValue));
        return this.getWorld().getPosition(vector3i.getX(), vector3i.getY(), vector3i.getZ());
    }

    @Override
    default SyncBlockPosition getRelative(Direction direction) {
        return this.getRelative(direction.getAsVector());
    }

    @Override
    default SyncExactPosition toExactPosition() {
        return this
                .getWorld()
                .getPosition(this.getX().doubleValue(), this.getY().doubleValue(), this.getZ().doubleValue());
    }
}
