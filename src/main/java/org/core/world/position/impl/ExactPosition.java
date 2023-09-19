package org.core.world.position.impl;

import org.core.vector.type.Vector3;
import org.core.world.direction.Direction;
import org.core.world.position.impl.async.ASyncBlockPosition;
import org.core.world.position.impl.async.ASyncExactPosition;
import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.impl.sync.SyncExactPosition;

public interface ExactPosition extends Position<Double> {

    @Override
    SyncExactPosition toSyncPosition();

    @Override
    ASyncExactPosition toAsyncPosition();

    @Override
    ExactPosition getRelative(Direction direction);

    @Override
    default Position<Double> getRelative(int x, int y, int z) {
        Vector3<Double> vector = this.getPosition().plus(x, y, z);
        return this.getWorld().getPosition(vector);
    }

    @Override
    default ExactPosition getRelative(double x, double y, double z) {
        Vector3<Double> vector = this.getPosition().plus(x, y, z);
        return this.getWorld().getPosition(vector.getX(), vector.getY(), vector.getZ());
    }
}
