package org.core.inventory.parts.snapshot;

import org.core.inventory.Inventory;
import org.core.inventory.parts.MainPlayerInventory;
import org.core.inventory.parts.Slot;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainPlayerInventorySnapshot implements MainPlayerInventory, InventoryPartSnapshot {

    protected final Set<Slot> slots = new HashSet<>();

    public MainPlayerInventorySnapshot(Inventory snapshot) {
        this(snapshot.getItemSlots().collect(Collectors.toList()));
    }

    public MainPlayerInventorySnapshot(Collection<? extends Slot> slots) {
        this.slots.addAll(slots.stream().map(Slot::createSnapshot).collect(Collectors.toSet()));
    }

    @Override
    public Stream<Slot> getItemSlots() {
        return this.slots.stream();
    }

    @Override
    public MainPlayerInventorySnapshot createSnapshot() {
        return new MainPlayerInventorySnapshot(this);
    }

    @Override
    public int getSlotCount() {
        return this.slots.size();
    }
}
