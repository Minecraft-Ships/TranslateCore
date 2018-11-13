package org.core.inventory.inventories.snapshots;

import org.core.inventory.InventorySnapshot;
import org.core.inventory.inventories.FurnaceInventory;
import org.core.inventory.parts.Slot;
import org.core.inventory.parts.snapshot.SlotSnapshot;
import org.core.world.position.BlockPosition;

public abstract class FurnaceInventorySnapshot implements FurnaceInventory, InventorySnapshot {

    protected SlotSnapshot fuelSlot;
    protected SlotSnapshot resultsSlot;
    protected SlotSnapshot smeltingSlot;
    protected BlockPosition position;

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
    public BlockPosition getPosition() {
        return this.position;
    }
}
