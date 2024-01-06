package org.core.world.position.block.entity;

import org.core.exceptions.BlockNotSupported;
import org.core.world.position.block.BlockType;
import org.core.world.position.impl.sync.SyncBlockPosition;

import java.util.Collection;
import java.util.Optional;

public interface TileEntitySnapshot<E extends LiveTileEntity> extends TileEntity {

    Class<E> getDeclaredClass();

    E apply(E tileEntity);

    Collection<BlockType> getSupportedBlocks();

    default E apply(SyncBlockPosition position) throws BlockNotSupported {
        if (this.getSupportedBlocks().stream().noneMatch(b -> position.getBlockType().equals(b))) {
            throw new BlockNotSupported(position.getBlockType(), this.getClass().getTypeName());
        }
        Optional<LiveTileEntity> opTileEntity = position.getTileEntity();
        if (opTileEntity.isEmpty()) {
            throw new BlockNotSupported(position.getBlockType(), this.getClass().getTypeName());
        }
        if (!this.getDeclaredClass().isAssignableFrom(opTileEntity.get().getClass())) {
            throw new BlockNotSupported(position.getBlockType(), this.getClass().getTypeName());
        }
        return this.apply((E) opTileEntity.get());
    }
}
