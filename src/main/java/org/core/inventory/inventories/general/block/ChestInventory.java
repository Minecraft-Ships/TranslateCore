package org.core.inventory.inventories.general.block;

import org.core.inventory.inventories.BlockAttachedInventory;
import org.core.inventory.inventories.snapshots.block.ChestInventorySnapshot;
import org.core.world.position.block.BlockType;
import org.core.world.position.block.BlockTypes;

public interface ChestInventory extends BlockAttachedInventory {

    @Override
    ChestInventorySnapshot createSnapshot();

    default BlockType[] getAllowedBlockType() {
        return new BlockType[]{BlockTypes.CHEST};
    }
}
