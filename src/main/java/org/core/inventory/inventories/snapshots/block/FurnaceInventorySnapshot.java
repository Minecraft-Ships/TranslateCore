package org.core.inventory.inventories.snapshots.block;

import org.core.inventory.InventorySnapshot;
import org.core.inventory.inventories.general.block.FurnaceInventory;
import org.core.inventory.parts.Slot;
import org.core.inventory.parts.snapshot.SlotSnapshot;
import org.core.world.position.block.entity.LiveTileEntity;
import org.core.world.position.block.entity.container.furnace.LiveFurnaceTileEntity;
import org.core.world.position.impl.sync.SyncBlockPosition;

import java.util.Optional;

public abstract class FurnaceInventorySnapshot implements FurnaceInventory, InventorySnapshot {

    protected SlotSnapshot fuelSlot;
    protected SlotSnapshot resultsSlot;
    protected SlotSnapshot smeltingSlot;
    protected SyncBlockPosition position;

    public void apply(FurnaceInventory fi){
        this.fuelSlot.getItem().ifPresent(f -> fi.getFuelSlot().setItem(f));
        this.resultsSlot.getItem().ifPresent(f -> fi.getResultsSlot().setItem(f));
        this.smeltingSlot.getItem().ifPresent(f -> fi.getSmeltingSlot().setItem(f));
    }

    @Override
    public Slot getFuelSlot() {
        return this.fuelSlot;
    }

    @Override
    public Slot getResultsSlot() {
        return this.resultsSlot;
    }

    @Override
    public Slot getSmeltingSlot(){
        return this.smeltingSlot;
    }

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
        if (!(opTile.get() instanceof LiveFurnaceTileEntity)){
            return;
        }
        LiveFurnaceTileEntity lfte = (LiveFurnaceTileEntity) opTile.get();
        apply(lfte.getInventory());
    }
}
