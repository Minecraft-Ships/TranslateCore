package org.core.world.position.impl.sync;

import org.core.vector.type.Vector3;
import org.core.world.direction.Direction;
import org.core.world.position.impl.ExactPosition;
import org.core.world.position.impl.Position;

import java.math.BigDecimal;

public interface SyncExactPosition extends SyncPosition<Double>, ExactPosition {

    @Override
    Vector3<Double> getPosition();

    @Override
    SyncBlockPosition toBlockPosition();

    @Override
    default SyncExactPosition getRelative(Vector3<?> vector){
        Vector3<Double> vectorD = this.getPosition().plus(vector.toVector(BigDecimal::doubleValue));
        return this.getWorld().getPosition(vectorD.getX(), vectorD.getY(), vectorD.getZ());
    }

    @Override
    default SyncExactPosition getRelative(Direction direction) {
        return this.getRelative(direction.getAsVector());
    }
}
