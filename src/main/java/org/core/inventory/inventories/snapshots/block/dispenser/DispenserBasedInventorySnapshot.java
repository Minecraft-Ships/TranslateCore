package org.core.inventory.inventories.snapshots.block.dispenser;

import org.core.inventory.Inventory;
import org.core.inventory.InventorySnapshot;
import org.core.inventory.inventories.general.block.dispenser.DispenserBasedInventory;
import org.core.inventory.item.stack.ItemStack;
import org.core.inventory.parts.Grid3x3;
import org.core.inventory.parts.InventoryPart;
import org.core.inventory.parts.Slot;
import org.core.world.position.impl.sync.SyncBlockPosition;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public abstract class DispenserBasedInventorySnapshot
        implements DispenserBasedInventory, InventorySnapshot, Inventory.Parent {

    protected SyncBlockPosition position;
    protected Grid3x3 grid;

    @Override
    public SyncBlockPosition getPosition() {
        return this.position;
    }

    @Override
    public Grid3x3 getItems() {
        return this.grid;
    }

    @Override
    public Stream<InventoryPart> getParts() {
        return Stream.of(this.grid);
    }

    @Override
    public Stream<Slot> getItemSlots() {
        return this.grid.getItemSlots();
    }


    public void apply(Inventory inv) {
        this.getItemSlots().filter(slot -> slot.getItem().isPresent()).forEach(slot -> {
            ItemStack item = slot.getItem().orElseThrow();
            Slot inventorySlot = inv
                    .getSlot(slot.getPosition().orElseThrow(() -> new IllegalStateException("Unknown slot position")))
                    .orElseThrow(() -> new IllegalStateException("Unknown slot position"));
            inventorySlot.setItem(item);
        });
    }
}
