package org.core.inventory.inventories.snapshots.block;

import org.core.inventory.Inventory;
import org.core.inventory.InventorySnapshot;
import org.core.inventory.inventories.general.block.ChestInventory;
import org.core.inventory.parts.Slot;
import org.core.world.position.block.entity.LiveTileEntity;
import org.core.world.position.block.entity.container.ContainerTileEntity;
import org.core.world.position.block.entity.container.chest.LiveChestTileEntity;
import org.core.world.position.impl.sync.SyncBlockPosition;

import java.util.Optional;

public abstract class ChestInventorySnapshot implements ChestInventory, InventorySnapshot {

    protected SyncBlockPosition position;

    @Override
    public SyncBlockPosition getPosition() {
        return this.position;
    }

    @Override
    public void apply() {
        Optional<LiveTileEntity> opTile = this.position.getTileEntity();
        if (opTile.isEmpty()) {
            return;
        }
        if (!(opTile.get() instanceof LiveChestTileEntity)) {
            return;
        }
        ContainerTileEntity lcte = (ContainerTileEntity) opTile.get();
        this.apply(lcte.getInventory());
    }

    public void apply(Inventory inv) {
        for (Slot slot : this.getSlots()) {
            slot
                    .getItem()
                    .ifPresent(f -> inv
                            .getSlot(slot
                                             .getPosition()
                                             .orElseThrow(() -> new IllegalStateException("Unknown slot position")))
                            .orElseThrow(() -> new IllegalStateException("Unknown slot position"))
                            .setItem(f));
        }
    }
}
