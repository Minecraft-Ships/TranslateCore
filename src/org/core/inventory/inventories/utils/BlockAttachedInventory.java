package org.core.inventory.inventories.utils;

import org.core.inventory.Inventory;
import org.core.world.position.BlockPosition;
import org.core.world.position.block.BlockType;
import org.core.world.position.block.entity.TileEntity;
import org.core.world.position.block.entity.TileEntitySnapshot;

import java.util.Optional;

public interface BlockAttachedInventory extends Inventory {

    public BlockType getBlockType();
    public Optional<BlockPosition> getPosition();

    public default Optional<TileEntity> getAttachedTileEntity(){
        if(!getPosition().isPresent()){
            return Optional.empty();
        }
        return getPosition().get().getTileEntity();
    }
}
