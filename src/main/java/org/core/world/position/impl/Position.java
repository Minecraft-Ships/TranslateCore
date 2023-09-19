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
import org.core.world.position.impl.async.ASyncPosition;
import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.impl.sync.SyncExactPosition;
import org.core.world.position.impl.sync.SyncPosition;

@ThreadSafe(impl = PlatformDetails.BUKKIT_ID)
public interface Position<N extends Number> {

    BlockPosition toBlockPosition();

    ExactPosition toExactPosition();

    SyncPosition<N> toSyncPosition();

    ASyncPosition<N> toAsyncPosition();


    @Deprecated
    static BlockPosition toBlock(Position<? extends Number> position) {
        return position.toBlockPosition();
    }

    @Deprecated
    static ExactPosition toExact(Position<? extends Number> position) {
        return position.toExactPosition();
    }

    @Deprecated
    static SyncBlockPosition toSync(BlockPosition position) {
        return position.toSyncPosition();
    }

    @Deprecated
    static ASyncBlockPosition toASync(BlockPosition position) {
        return position.toAsyncPosition();
    }

    @Deprecated
    static SyncExactPosition toSync(ExactPosition position) {
        return position.toSyncPosition();
    }

    @Deprecated
    static ASyncExactPosition toASync(ExactPosition position) {
        return position.toAsyncPosition();
    }

    Vector3<Integer> getChunkPosition();

    WorldExtent getWorld();

    BlockSnapshot<? extends BlockPosition> getBlockDetails();

    Vector3<N> getPosition();

    Position<N> getRelative(Vector3<?> vector);

    Position<N> getRelative(int x, int y, int z);

    ExactPosition getRelative(double x, double y, double z);

    default BlockType getBlockType() {
        return this.getBlockDetails().getType();
    }

    default Position<N> getRelative(Direction direction) {
        Vector3<Integer> vector = direction.getAsVector();
        return this.getRelative(vector.getX(), vector.getY(), vector.getZ());
    }

    default N getX() {
        return this.getPosition().getX();
    }

    default N getY() {
        return this.getPosition().getY();
    }

    default N getZ() {
        return this.getPosition().getZ();
    }
}
