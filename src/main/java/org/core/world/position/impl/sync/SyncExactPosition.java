package org.core.world.position.impl.sync;

import org.core.vector.type.Vector3;
import org.core.world.direction.Direction;
import org.core.world.position.impl.ExactPosition;
import org.core.world.position.impl.async.ASyncExactPosition;

import java.math.BigDecimal;

public interface SyncExactPosition extends SyncPosition<Double>, ExactPosition {

    @Override
    SyncBlockPosition toBlockPosition();

    @Override
    @Deprecated
    default SyncExactPosition toExactPosition() {
        return this;
    }

    @Override
    @Deprecated
    default SyncExactPosition toSyncPosition() {
        return this;
    }

    @Deprecated(forRemoval = true)
    @Override
    default ASyncExactPosition toAsyncPosition() {
        return this.getWorld().getAsyncPosition(this.getX(), this.getY(), this.getZ());
    }

    @Override
    Vector3<Double> getPosition();

    @Override
    default SyncExactPosition getRelative(Vector3<?> vector) {
        Vector3<Double> vectorD = this.getPosition().plus(vector.toVector(BigDecimal::doubleValue));
        return this.getWorld().getPosition(vectorD.getX(), vectorD.getY(), vectorD.getZ());
    }

    @Override
    default SyncExactPosition getRelative(Direction direction) {
        return this.getRelative(direction.getAsVector());
    }
}
