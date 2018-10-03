package org.core.inventory.parts.snapshot;

import org.core.inventory.parts.MainPlayerInventory;
import org.core.inventory.parts.Slot;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MainPlayerInventorySnapshot implements MainPlayerInventory, InventoryPartSnapshot {

    protected Set<Slot> slots = new HashSet<>();

    public MainPlayerInventorySnapshot(MainPlayerInventory snapshot){
        this(snapshot.getSlots());
    }

    public MainPlayerInventorySnapshot(Collection<Slot> slots){
        slots.stream().forEach(s -> this.slots.add(s.createSnapshot()));
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
