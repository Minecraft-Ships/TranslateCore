package org.core.inventory.parts.snapshot;

import org.core.inventory.Inventory;
import org.core.inventory.parts.Grid2x2;
import org.core.inventory.parts.Slot;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Grid2x2Snapshot implements InventoryPartSnapshot, Grid2x2 {

    protected Set<Slot> slots = new HashSet<>();

    public Grid2x2Snapshot(Inventory part) {
        this(part.getSlots());
    }

    public Grid2x2Snapshot(Slot... slots) {
        this(Arrays.asList(slots));
    }

    public Grid2x2Snapshot(Collection<? extends Slot> slots) {
        if (slots.size() > 4) {
            throw new IllegalArgumentException("Grid 2x2 cannot have more then 4 slots");
        }
        this.slots.addAll(slots.stream().map(Slot::createSnapshot).collect(Collectors.toSet()));
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
