package org.core.inventory.inventories.snapshots.block.dispenser;

import org.core.inventory.Inventory;
import org.core.inventory.InventorySnapshot;
import org.core.inventory.inventories.general.block.dispenser.DispenserBasedInventory;
import org.core.inventory.parts.Grid3x3;
import org.core.inventory.parts.InventoryPart;
import org.core.inventory.parts.Slot;
import org.core.world.position.impl.sync.SyncBlockPosition;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class DispenserBasedInventorySnapshot implements DispenserBasedInventory, InventorySnapshot, Inventory.Parent {

    protected SyncBlockPosition position;
    protected Grid3x3 grid;

    @Override
    public SyncBlockPosition getPosition(){
        return this.position;
    }

    @Override
    public Grid3x3 getItems() {
        return this.grid;
    }

    @Override
    public Set<InventoryPart> getFirstChildren() {
        return new HashSet<>(Collections.singletonList(this.grid));
    }

    @Override
    public Set<Slot> getSlots() {
        return this.grid.getSlots();
    }


    public void apply(DispenserBasedInventory inv){
        for(Slot slot : this.getSlots()){
            slot.getItem().ifPresent(f -> inv.getSlot(slot.getPosition().get()).get().setItem(f));
        }
    }
}
