package org.core.inventory.inventories.snapshots.block;

import org.core.inventory.InventorySnapshot;
import org.core.inventory.inventories.general.block.ChestInventory;
import org.core.inventory.parts.Slot;
import org.core.world.position.block.entity.LiveTileEntity;
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
    public void apply(){
        Optional<LiveTileEntity> opTile = this.position.getTileEntity();
        if(!opTile.isPresent()){
            return;
        }
        if (!(opTile.get() instanceof LiveChestTileEntity)){
            return;
        }
        LiveChestTileEntity lcte = (LiveChestTileEntity)opTile.get();
        apply(lcte.getInventory());
    }

    public void apply(ChestInventory inv){
        for(Slot slot : this.getSlots()){
            slot.getItem().ifPresent(f -> inv.getSlot(slot.getPosition().get()).get().setItem(f));
        }
    }
}
