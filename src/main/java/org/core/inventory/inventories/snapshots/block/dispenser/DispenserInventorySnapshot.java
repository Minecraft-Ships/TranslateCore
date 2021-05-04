package org.core.inventory.inventories.snapshots.block.dispenser;

import org.core.inventory.inventories.general.block.dispenser.DispenserInventory;
import org.core.world.position.block.BlockType;
import org.core.world.position.block.BlockTypes;
import org.core.world.position.block.entity.LiveTileEntity;
import org.core.world.position.block.entity.container.dispenser.LiveDispenserTileEntity;

import java.util.Optional;

public abstract class DispenserInventorySnapshot extends DispenserBasedInventorySnapshot implements DispenserInventory {

    @Override
    public void apply() {
        Optional<LiveTileEntity> opTile = this.position.getTileEntity();
        if (!opTile.isPresent()) {
            return;
        }
        if (!(opTile.get() instanceof LiveDispenserTileEntity)) {
            return;
        }
        LiveDispenserTileEntity ldte = (LiveDispenserTileEntity) opTile.get();
        apply(ldte.getInventory());
    }

    @Override
    public BlockType[] getAllowedBlockType() {
        return new BlockType[]{BlockTypes.DISPENSER};
    }
}
