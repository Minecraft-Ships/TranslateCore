package org.core.world.position;

import org.core.entity.Entity;
import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;
import org.core.vector.Vector3;
import org.core.vector.types.Vector3Int;
import org.core.world.WorldExtent;
import org.core.world.position.block.BlockType;
import org.core.world.position.block.details.BlockDetails;
import org.core.world.position.block.entity.TileEntity;

import java.util.Optional;

public interface Position<A extends Number> {

    Vector3Int getChunkPosition();

    Vector3<A> getPosition();

    WorldExtent getWorld();

    BlockDetails getBlockDetails();

    Optional<TileEntity> getTileEntity();

    <E extends Entity, S extends EntitySnapshot<E>> Optional<S> createEntity(EntityType<E, S> type);

    default BlockType getBlockType() {
        return getBlockDetails().getType();
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
}
