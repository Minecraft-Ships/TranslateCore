package org.core.world.position.block.entity;

import org.core.exceptions.BlockNotSupported;
import org.core.world.position.block.BlockType;
import org.core.world.position.impl.sync.SyncBlockPosition;

import java.util.Collection;
import java.util.Optional;

public interface TileEntitySnapshot <E extends LiveTileEntity> extends TileEntity {

    Class<E> getDeclaredClass();

    E apply(E tileEntity);

    Collection<BlockType> getSupportedBlocks();

    @SuppressWarnings("unchecked")
    default E apply(SyncBlockPosition position) throws BlockNotSupported {
        if(!getSupportedBlocks().stream().anyMatch(b -> position.getBlockType().equals(b))){
            throw new BlockNotSupported(position.getBlockType(), this.getClass().getTypeName());
        }
        Optional<LiveTileEntity> opTileEntity = position.getTileEntity();
        if(!opTileEntity.isPresent()){
            throw new BlockNotSupported(position.getBlockType(), this.getClass().getTypeName());
        }
        if(!getDeclaredClass().isAssignableFrom(opTileEntity.get().getClass())){
            throw new BlockNotSupported(position.getBlockType(), this.getClass().getTypeName());
        }
        return apply((E)opTileEntity.get());
    }
}
