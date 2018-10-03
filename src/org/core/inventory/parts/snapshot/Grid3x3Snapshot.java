package org.core.inventory.parts.snapshot;

import org.core.inventory.parts.Grid3x3;
import org.core.inventory.parts.Slot;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Grid3x3Snapshot implements Grid3x3, InventoryPartSnapshot {

    protected Set<Slot> slots = new HashSet<>();

    public Grid3x3Snapshot(Grid3x3 grid){
        this(grid.getSlots());
    }

    public Grid3x3Snapshot(Slot... slots){
        this(Arrays.asList(slots));
    }

    public Grid3x3Snapshot(Collection<Slot> slots){
        slots.stream().forEach(s -> this.slots.add(s.createSnapshot()));
    }

    @Override
    public Set<Slot> getSlots() {
        return this.slots;
    }

    @Override
    public Grid3x3Snapshot createSnapshot() {
        return new Grid3x3Snapshot(this);
    }
}
