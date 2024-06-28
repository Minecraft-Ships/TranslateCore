package org.core.world.position.impl.async;

import org.core.vector.type.Vector3;
import org.core.world.direction.Direction;
import org.core.world.position.impl.ExactPosition;
import org.core.world.position.impl.sync.SyncExactPosition;

import java.math.BigDecimal;

@Deprecated(forRemoval = true)
public interface ASyncExactPosition extends ASyncPosition<Double>, ExactPosition {

    @Override
    ASyncBlockPosition toBlockPosition();

    @Deprecated
    @Override
    default ASyncExactPosition toExactPosition() {
        return this;
    }

    @Override
    default SyncExactPosition toSyncPosition() {
        return this.getWorld().getPosition(this.getX(), this.getY(), this.getZ());
    }

    @Deprecated
    @Override
    default ASyncExactPosition toAsyncPosition() {
        return this;
    }

    @Override
    default ASyncExactPosition getRelative(Vector3<?> vector) {
        Vector3<Double> vectorD = this.getPosition().plus(vector.toVector(BigDecimal::doubleValue));
        return this.getWorld().getAsyncPosition(vectorD.getX(), vectorD.getY(), vectorD.getZ());
    }

    @Override
    default ASyncExactPosition getRelative(Direction direction) {
        return this.getRelative(direction.getAsVector());
    }
}
