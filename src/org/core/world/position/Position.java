package org.core.world.position;

import org.core.stores.number.TripleNumberStore;
import org.core.stores.number.vector.ThreeIntegerVector;
import org.core.world.WorldExtent;
import org.core.world.position.block.BlockType;
import org.core.world.position.block.details.BlockDetails;
import org.core.world.position.block.entity.TileEntity;

import java.util.Optional;

public interface Position<A extends Number> {

    ThreeIntegerVector getChunkPosition();

    TripleNumberStore<A> getPosition();

    WorldExtent getWorld();

    BlockDetails getBlockDetails();

    Optional<TileEntity> getTileEntity();

    default BlockType getBlockType() {
        return getBlockDetails().getType();
    }

    default A getX() {
        return getPosition().getOne();
    }

    default A getY() {
        return getPosition().getTwo();
    }

    default A getZ() {
        return getPosition().getThree();
    }
}
