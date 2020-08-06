package org.core.world.position.impl;

import org.core.entity.LiveEntity;
import org.core.vector.Vector3;
import org.core.vector.types.Vector3Int;
import org.core.world.direction.Direction;
import org.core.world.direction.FourFacingDirection;
import org.core.world.position.block.BlockTypes;
import org.core.world.position.block.details.BlockDetails;
import org.core.world.position.block.details.BlockSnapshot;
import org.core.world.position.impl.sync.SyncBlockPosition;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public interface BlockPosition extends Position<Integer> {

    ExactPosition toExactPosition();

    @Override
    Vector3Int getPosition();

    BlockPosition getRelative(Vector3<Integer> vector);

    BlockPosition getRelative(Vector3Int vector);

    @Override
    default BlockPosition getRelative(Direction direction){
        return (SyncBlockPosition) Position.super.getRelative(direction);
    }

    default Set<LiveEntity> getAttachedEntities(){
        return this.getWorld().getEntities().stream().filter(e -> {
            System.out.println("\tTesting " + e.getType().getId());
            Optional<SyncBlockPosition> opAttached = e.getAttachedTo();
            if(!opAttached.isPresent()){
                System.out.println("\t\tNo Attachment found");
                return false;
            }
            System.out.println("\t\tComparing " + opAttached.get().equals(this));
            return opAttached.get().equals(this);
        }).collect(Collectors.toSet());
    }

    default boolean isInLineOfSight(final Vector3Int vector, FourFacingDirection direction){
        return isInLineOfSight(vector, direction, BlockTypes.AIR.get().getDefaultBlockDetails(), BlockTypes.CAVE_AIR.get().getDefaultBlockDetails(), BlockTypes.VOID_AIR.get().getDefaultBlockDetails());
    }

    default boolean isInLineOfSight(final Vector3Int vector, FourFacingDirection direction, BlockDetails... details){
        return isInLineOfSight(vector, direction, Arrays.asList(details));
    }

    default boolean isInLineOfSight(final Vector3Int vector, FourFacingDirection direction, final Collection<BlockDetails> ignored){
        return isInLineOfSight(vector.getX(), vector.getY(), vector.getZ(), direction, ignored);
    }

    default boolean isInLineOfSight(final int x, final int y, final int z, FourFacingDirection direction){
        return isInLineOfSight(x, y, z, direction, BlockTypes.AIR.get().getDefaultBlockDetails(), BlockTypes.CAVE_AIR.get().getDefaultBlockDetails(), BlockTypes.VOID_AIR.get().getDefaultBlockDetails());
    }

    default boolean isInLineOfSight(final int x, final int y, final int z, FourFacingDirection direction, BlockDetails... details){
        return isInLineOfSight(x, y, z, direction, Arrays.asList(details));
    }

    default boolean isInLineOfSight(final int x, final int y, final int z, FourFacingDirection direction, final Collection<BlockDetails> ignored){
        if(x == getX() && y == getY() && z == getZ()){
            return true;
        }
        int diffX = this.getX() - x;
        int diffY = this.getY() - y;
        int diffZ = this.getZ() - z;
        if(!((diffX == 0 && diffY == 0 && (direction.equals(FourFacingDirection.EAST) || direction.equals(FourFacingDirection.WEST))) ||
                        (diffX == 0 && diffZ == 0 && (direction.equals(FourFacingDirection.UP) || direction.equals(FourFacingDirection.DOWN))) ||
                        (diffY == 0 && diffZ == 0 && (direction.equals(FourFacingDirection.NORTH) || direction.equals(FourFacingDirection.SOUTH))))){
            return false;
        }
        int startX = this.getX();
        int startY = this.getY();
        int startZ = this.getZ();
        int diff = Math.max(Math.max(diffX, diffY), diffZ);
        if(diff == 0){
            diff = Math.min(Math.min(diffX, diffY), diffZ);
        }
        if(diff < 0){
            startX = x;
            startY = y;
            startZ = z;
            diff = -diff;
        }
        for(int A = 0; A < diff; A++){
            int plusX = direction.getAsVector().getX() * A;
            int plusY = direction.getAsVector().getY() * A;
            int plusZ = direction.getAsVector().getZ() * A;

            BlockPosition position = this.getWorld().getPosition(startX + plusX, startY + plusY, startZ + plusZ);
            BlockSnapshot<? extends Position<Integer>> snapshot = position.getBlockDetails();
            if (ignored.stream().noneMatch(b -> b.equals(snapshot))){
                return false;
            }
        }
        return true;
    }
}