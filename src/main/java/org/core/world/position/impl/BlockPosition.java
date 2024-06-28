package org.core.world.position.impl;

import org.core.entity.LiveEntity;
import org.core.vector.type.Vector3;
import org.core.world.direction.Direction;
import org.core.world.direction.FourFacingDirection;
import org.core.world.position.block.BlockTypes;
import org.core.world.position.block.details.BlockDetails;
import org.core.world.position.block.details.BlockSnapshot;
import org.core.world.position.impl.async.ASyncBlockPosition;
import org.core.world.position.impl.sync.SyncBlockPosition;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface BlockPosition extends Position<Integer> {

    @Override
    SyncBlockPosition toSyncPosition();

    @Override
    @Deprecated(forRemoval = true)
    ASyncBlockPosition toAsyncPosition();

    @Override
    BlockPosition getRelative(Vector3<?> vector);

    @Override
    default Position<Integer> getRelative(int x, int y, int z) {
        Vector3<Integer> vector = this.getPosition().plus(x, y, z);
        return this.getWorld().getPosition(vector);
    }

    @Override
    default ExactPosition getRelative(double x, double y, double z) {
        Vector3<Double> vector = this.getPosition().toVector(Vector3.DOUBLE_CONVERTER).plus(x, y, z);
        return this.getWorld().getPosition(vector.getX(), vector.getY(), vector.getZ());
    }

    @Override
    default BlockPosition getRelative(Direction direction) {
        Vector3<Integer> vector = direction.getAsVector();
        return (BlockPosition) this.getRelative(vector.getX(), vector.getY(), vector.getZ());
    }

    @Deprecated(forRemoval = true)
    default Set<LiveEntity> getAttachedEntities() {
        return this.getAttachedLiveEntities().collect(Collectors.toSet());
    }

    default Stream<LiveEntity> getAttachedLiveEntities() {
        return this.getWorld().getLiveEntities().filter(e -> {
            Optional<SyncBlockPosition> opAttached = e.getAttachedTo();
            return opAttached.map(syncBlockPosition -> syncBlockPosition.equals(this)).orElse(false);
        });
    }

    default boolean isInLineOfSight(final Vector3<Integer> vector, FourFacingDirection direction) {
        return this.isInLineOfSight(vector, direction, BlockTypes.AIR.getDefaultBlockDetails(),
                                    BlockTypes.CAVE_AIR.getDefaultBlockDetails(),
                                    BlockTypes.VOID_AIR.getDefaultBlockDetails());
    }

    default boolean isInLineOfSight(final Vector3<Integer> vector,
                                    FourFacingDirection direction,
                                    BlockDetails... details) {
        return this.isInLineOfSight(vector, direction, Arrays.asList(details));
    }

    default boolean isInLineOfSight(final Vector3<Integer> vector,
                                    FourFacingDirection direction,
                                    final Collection<BlockDetails> ignored) {
        return this.isInLineOfSight(vector.getX(), vector.getY(), vector.getZ(), direction, ignored);
    }

    default boolean isInLineOfSight(final int x, final int y, final int z, FourFacingDirection direction) {
        return this.isInLineOfSight(x, y, z, direction, BlockTypes.AIR.getDefaultBlockDetails(),
                                    BlockTypes.CAVE_AIR.getDefaultBlockDetails(),
                                    BlockTypes.VOID_AIR.getDefaultBlockDetails());
    }

    default boolean isInLineOfSight(final int x,
                                    final int y,
                                    final int z,
                                    FourFacingDirection direction,
                                    BlockDetails... details) {
        return this.isInLineOfSight(x, y, z, direction, Arrays.asList(details));
    }

    default boolean isInLineOfSight(final int x,
                                    final int y,
                                    final int z,
                                    FourFacingDirection direction,
                                    final Collection<BlockDetails> ignored) {
        if (x == this.getX() && y == this.getY() && z == this.getZ()) {
            return true;
        }
        int diffX = this.getX() - x;
        int diffY = this.getY() - y;
        int diffZ = this.getZ() - z;
        if (!((diffX == 0 && diffY == 0 && (direction.equals(FourFacingDirection.EAST) || direction.equals(
                FourFacingDirection.WEST))) || (diffX == 0 && diffZ == 0 && (direction.equals(FourFacingDirection.UP)
                || direction.equals(FourFacingDirection.DOWN))) || (diffY == 0 && diffZ == 0 && (
                direction.equals(FourFacingDirection.NORTH) || direction.equals(FourFacingDirection.SOUTH))))) {
            return false;
        }
        int startX = this.getX();
        int startY = this.getY();
        int startZ = this.getZ();
        int diff = Math.max(Math.max(diffX, diffY), diffZ);
        if (diff == 0) {
            diff = Math.min(Math.min(diffX, diffY), diffZ);
        }
        if (diff < 0) {
            startX = x;
            startY = y;
            startZ = z;
            diff = -diff;
        }
        for (int index = 0; index < diff; index++) {
            int plusX = direction.getAsVector().getX() * index;
            int plusY = direction.getAsVector().getY() * index;
            int plusZ = direction.getAsVector().getZ() * index;

            BlockPosition position = this.getWorld().getPosition(startX + plusX, startY + plusY, startZ + plusZ);
            BlockSnapshot<? extends BlockPosition> snapshot = position.getBlockDetails();
            if (ignored.stream().noneMatch(b -> b.equals(snapshot))) {
                return false;
            }
        }
        return true;
    }
}
