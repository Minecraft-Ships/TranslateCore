package org.core.inventory.parts.snapshot;

import org.core.inventory.Inventory;
import org.core.inventory.parts.Grid3x3;
import org.core.inventory.parts.Slot;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grid3x3Snapshot implements Grid3x3, InventoryPartSnapshot {

    protected final Set<Slot> slots = new HashSet<>();

    public Grid3x3Snapshot(Inventory grid) {
        this(grid.getItemSlots().collect(Collectors.toList()));
    }

    public Grid3x3Snapshot(Slot... slots) {
        this(Arrays.asList(slots));
    }

    public Grid3x3Snapshot(Collection<? extends Slot> slots) {
        if (slots.size() > 9) {
            throw new IllegalArgumentException("Inventory cannot have more then 9 slots");
        }
        this.slots.addAll(slots.stream().map(Slot::createSnapshot).collect(Collectors.toSet()));
    }

    @Override
    public Stream<Slot> getItemSlots() {
        return this.slots.stream();
    }

    @Override
    public Grid3x3Snapshot createSnapshot() {
        return new Grid3x3Snapshot(this);
    }

    @Override
    public int getSlotCount() {
        return this.slots.size();
    }
}
