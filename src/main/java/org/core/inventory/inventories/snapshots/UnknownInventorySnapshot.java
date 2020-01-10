package org.core.inventory.inventories.snapshots;

import org.core.inventory.InventorySnapshot;
import org.core.inventory.parts.Slot;
import org.core.inventory.parts.snapshot.SlotSnapshot;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UnknownInventorySnapshot implements InventorySnapshot {

    private Set<Slot> slots = new HashSet<>();

    public UnknownInventorySnapshot(){

    }

    public UnknownInventorySnapshot(InventorySnapshot inventory){
        this.slots.addAll(inventory.getSlots());
    }

    public UnknownInventorySnapshot(Collection<SlotSnapshot> collection){
        this.slots.addAll(collection);
    }

    @Override
    @Deprecated
    public void apply() {
    }

    @Override
    public Set<Slot> getSlots() {
        return this.slots;
    }

    @Override
    public Optional<Slot> getSlot(int slotPos) {
        return this.slots.stream().filter(s -> s.getPosition().isPresent()).filter(s -> s.getPosition().get() == slotPos).findAny();
    }

    @Override
    public UnknownInventorySnapshot createSnapshot() {
        return new UnknownInventorySnapshot(this);
    }
}
