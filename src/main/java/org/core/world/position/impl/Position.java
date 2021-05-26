package org.core.world.position.impl;

import org.core.platform.PlatformDetails;
import org.core.threadsafe.ThreadSafe;
import org.core.vector.type.Vector3;
import org.core.world.WorldExtent;
import org.core.world.direction.Direction;
import org.core.world.position.block.BlockType;
import org.core.world.position.block.details.BlockSnapshot;
import org.core.world.position.impl.async.ASyncBlockPosition;
import org.core.world.position.impl.async.ASyncExactPosition;
import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.impl.sync.SyncExactPosition;

@ThreadSafe(impl = {PlatformDetails.BUKKIT_ID})
public interface Position<N extends Number> {

    Vector3<Integer> getChunkPosition();

    WorldExtent getWorld();

    BlockSnapshot<? extends BlockPosition> getBlockDetails();

    Vector3<N> getPosition();

    Position<N> getRelative(Vector3<?> vector);

    Position<N> getRelative(int x, int y, int z);

    ExactPosition getRelative(double x, double y, double z);

    default BlockType getBlockType() {
        return getBlockDetails().getType();
    }

    default Position<N> getRelative(Direction direction) {
        Vector3<Integer> vector = direction.getAsVector();
        return getRelative(vector.getX(), vector.getY(), vector.getZ());
    }

    default N getX() {
        return getPosition().getX();
    }

    default N getY() {
        return getPosition().getY();
    }

    default N getZ() {
        return getPosition().getZ();
    }

    static BlockPosition toBlock(Position<? extends Number> position) {
        if (position instanceof BlockPosition) {
            return (BlockPosition) position;
        }
        if (position instanceof ExactPosition) {
            return ((SyncExactPosition) position).toBlockPosition();
        }
        throw new IllegalStateException("Unknown Position implementation");
    }

    static ExactPosition toExact(Position<? extends Number> position) {
        if (position instanceof ExactPosition) {
            return (ExactPosition) position;
        }
        if (position instanceof BlockPosition) {
            return ((BlockPosition) position).toExactPosition();
        }
        throw new IllegalStateException("Unknown Position implementation");
    }

    static SyncBlockPosition toSync(BlockPosition position) {
        if (position instanceof SyncBlockPosition) {
            return (SyncBlockPosition) position;
        }
        return position.getWorld().getPosition(position.getX(), position.getY(), position.getZ());
    }

    static ASyncBlockPosition toASync(BlockPosition position) {
        if (position instanceof ASyncBlockPosition) {
            return (ASyncBlockPosition) position;
        }
        return position.getWorld().getAsyncPosition(position.getX(), position.getY(), position.getZ());
    }

    static SyncExactPosition toSync(ExactPosition position) {
        if (position instanceof SyncExactPosition) {
            return (SyncExactPosition) position;
        }
        return position.getWorld().getPosition(position.getX(), position.getY(), position.getZ());
    }

    static ASyncExactPosition toASync(ExactPosition position) {
        if (position instanceof SyncExactPosition) {
            return (ASyncExactPosition) position;
        }
        return position.getWorld().getAsyncPosition(position.getX(), position.getY(), position.getZ());
    }
}
