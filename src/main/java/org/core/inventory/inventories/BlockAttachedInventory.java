package org.core.inventory.inventories;

import org.core.inventory.PositionableInventory;
import org.core.world.position.block.BlockType;
import org.core.world.position.block.entity.LiveTileEntity;

import java.util.Optional;

public interface BlockAttachedInventory extends PositionableInventory.BlockPositionableInventory {

    public BlockType[] getAllowedBlockType();

    default Optional<LiveTileEntity> getAttachedTileEntity(){
        return getPosition().getTileEntity();
    }
}
