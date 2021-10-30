package org.core.inventory.parts.snapshot;

import org.core.inventory.parts.Hotbar;
import org.core.inventory.parts.Slot;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class HotbarSnapshot implements Hotbar, InventoryPartSnapshot {

    protected int selected;
    protected Set<Slot> slots = new HashSet<>();

    public HotbarSnapshot(Hotbar bar){
        this(bar.getSelectedSlotPos(), bar.getSlots());
    }

    public HotbarSnapshot(int selected, Slot... slots){
        this(selected, Arrays.asList(slots));
    }

    public HotbarSnapshot(int selected, Collection<? extends Slot> slots){
        this.selected = selected;
        this.slots.addAll(slots.stream().map(Slot::createSnapshot).collect(Collectors.toSet()));
    }

    @Override
    public int getSelectedSlotPos() {
        return this.selected;
    }

    @Override
    public Set<Slot> getSlots() {
        return this.slots;
    }

    @Override
    public HotbarSnapshot createSnapshot() {
        return new HotbarSnapshot(this);
    }
}
