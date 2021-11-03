package org.core.inventory.parts.snapshot;

import org.core.inventory.Inventory;
import org.core.inventory.parts.MainPlayerInventory;
import org.core.inventory.parts.Slot;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MainPlayerInventorySnapshot implements MainPlayerInventory, InventoryPartSnapshot {

    protected final Set<Slot> slots = new HashSet<>();

    public MainPlayerInventorySnapshot(Inventory snapshot) {
        this(snapshot.getSlots());
    }

    public MainPlayerInventorySnapshot(Collection<? extends Slot> slots) {
        this.slots.addAll(slots.stream().map(Slot::createSnapshot).collect(Collectors.toSet()));
    }

    @Override
    public Set<Slot> getSlots() {
        return this.slots;
    }

    @Override
    public MainPlayerInventorySnapshot createSnapshot() {
        return new MainPlayerInventorySnapshot(this);
    }
}
