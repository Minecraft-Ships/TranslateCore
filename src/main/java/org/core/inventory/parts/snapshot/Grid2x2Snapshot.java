package org.core.inventory.parts.snapshot;

import org.core.inventory.parts.Grid2x2;
import org.core.inventory.parts.Slot;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Grid2x2Snapshot implements InventoryPartSnapshot, Grid2x2 {

    protected Set<Slot> slots = new HashSet<>();

    public Grid2x2Snapshot(Grid2x2 part){
        this(part.getSlots());
    }

    public Grid2x2Snapshot(Slot... slots){
        this(Arrays.asList(slots));
    }

    public Grid2x2Snapshot(Collection<Slot> slots){
        slots.stream().forEach(s -> this.slots.add(s.createSnapshot()));
    }

    @Override
    public Set<Slot> getSlots() {
        return this.slots;
    }

    @Override
    public Grid2x2Snapshot createSnapshot() {
        return new Grid2x2Snapshot(this);
    }
}
