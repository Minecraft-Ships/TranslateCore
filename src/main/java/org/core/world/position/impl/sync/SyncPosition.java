package org.core.world.position.impl.sync;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;
import org.core.entity.LiveEntity;
import org.core.entity.living.human.player.LivePlayer;
import org.core.vector.Vector3;
import org.core.vector.types.Vector3Int;
import org.core.world.position.block.BlockType;
import org.core.world.position.block.details.BlockDetails;
import org.core.world.position.block.details.BlockSnapshot;
import org.core.world.position.block.entity.LiveTileEntity;
import org.core.world.position.flags.PositionFlag;
import org.core.world.position.impl.Position;

import java.util.Optional;

public interface SyncPosition<A extends Number> extends Position<A> {

    @Override
    BlockSnapshot getBlockDetails();

    SyncPosition<A> setBlock(BlockDetails details, PositionFlag.SetFlag... flags);

    SyncPosition<A> setBlock(BlockDetails details, LivePlayer... player);

    SyncPosition<A> resetBlock(LivePlayer... player);

    Optional<LiveTileEntity> getTileEntity();

    <E extends LiveEntity, S extends EntitySnapshot<E>> Optional<S> createEntity(EntityType<E, S> type);

    SyncPosition<A> destroy();

    default SyncPosition<A> setBlock(BlockType type) {
        return setBlock(type.getDefaultBlockDetails());
    }

    default SyncPosition<A> setBlock(BlockDetails details){
        return setBlock(details, new PositionFlag.SetFlag[0]);
    }

    @Override
    default SyncPosition<A> getRelative(Vector3Int vector){
        return getWorld().getPosition(getPosition().add(vector));
    }

    @Override
    default SyncPosition<A> getRelative(Vector3<A> vector){
        return getWorld().getPosition(vector.add(getPosition()));
    }

}
