package org.core.world.position.impl;

import org.core.platform.PlatformDetails;
import org.core.threadsafe.ThreadSafe;
import org.core.vector.Vector3;
import org.core.vector.types.Vector3Int;
import org.core.world.WorldExtent;
import org.core.world.direction.Direction;
import org.core.world.position.block.BlockType;
import org.core.world.position.block.details.BlockSnapshot;
import org.core.world.position.impl.async.ASyncBlockPosition;
import org.core.world.position.impl.async.ASyncExactPosition;
import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.impl.sync.SyncExactPosition;

@ThreadSafe(impl = {PlatformDetails.BUKKIT_ID})
public interface Position<A extends Number> {

    Vector3Int getChunkPosition();
    WorldExtent getWorld();
    BlockSnapshot<? extends Position<A>> getBlockDetails();
    Vector3<A> getPosition();
    default BlockType getBlockType() {
        return getBlockDetails().getType();
    }
    Position<A> getRelative(Vector3Int vector);
    Position<A> getRelative(Vector3<A> vector);
    default Position<A> getRelative(Direction direction){
        return getRelative(direction.getAsVector());
    }
    default A getX() {
        return getPosition().getX();
    }
    default A getY() {
        return getPosition().getY();
    }
    default A getZ() {
        return getPosition().getZ();
    }

    static BlockPosition toBlock(Position<? extends Number> position){
        if(position instanceof BlockPosition){
            return (BlockPosition)position;
        }
        if(position instanceof ExactPosition){
            return ((SyncExactPosition)position).toBlockPosition();
        }
        throw new IllegalStateException("Unknown Position implementation");
    }

    static ExactPosition toExact(Position<? extends Number> position){
        if(position instanceof ExactPosition){
            return (ExactPosition)position;
        }
        if(position instanceof BlockPosition){
            return ((BlockPosition)position).toExactPosition();
        }
        throw new IllegalStateException("Unknown Position implementation");
    }

    static SyncBlockPosition toSync(BlockPosition position){
        if(position instanceof SyncBlockPosition){
            return (SyncBlockPosition) position;
        }
        return position.getWorld().getPosition(position.getX(), position.getY(), position.getZ());
    }

    static ASyncBlockPosition toASync(BlockPosition position){
        if(position instanceof ASyncBlockPosition){
            return (ASyncBlockPosition) position;
        }
        return position.getWorld().getAsyncPosition(position.getX(), position.getY(), position.getZ());
    }

    static SyncExactPosition toSync(ExactPosition position){
        if(position instanceof SyncExactPosition){
            return (SyncExactPosition) position;
        }
        return position.getWorld().getPosition(position.getX(), position.getY(), position.getZ());
    }

    static ASyncExactPosition toASync(ExactPosition position){
        if(position instanceof SyncExactPosition){
            return (ASyncExactPosition) position;
        }
        return position.getWorld().getAsyncPosition(position.getX(), position.getY(), position.getZ());
    }
}
