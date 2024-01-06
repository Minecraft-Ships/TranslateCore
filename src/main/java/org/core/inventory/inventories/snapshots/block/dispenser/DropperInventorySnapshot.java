package org.core.inventory.inventories.snapshots.block.dispenser;

import org.core.inventory.inventories.general.block.dispenser.DropperInventory;
import org.core.world.position.block.BlockType;
import org.core.world.position.block.BlockTypes;
import org.core.world.position.block.entity.LiveTileEntity;
import org.core.world.position.block.entity.container.ContainerTileEntity;
import org.core.world.position.block.entity.container.dropper.LiveDropperTileEntity;

import java.util.Optional;

public abstract class DropperInventorySnapshot extends DispenserBasedInventorySnapshot implements DropperInventory {

    @Override
    public void apply() {
        Optional<LiveTileEntity> opTile = this.position.getTileEntity();
        if (opTile.isEmpty()) {
            return;
        }
        if (!(opTile.get() instanceof LiveDropperTileEntity)) {
            return;
        }
        ContainerTileEntity ldte = (ContainerTileEntity) opTile.get();
        this.apply(ldte.getInventory());
    }

    @Override
    public BlockType[] getAllowedBlockType() {
        return new BlockType[]{BlockTypes.DROPPER};
    }
}
