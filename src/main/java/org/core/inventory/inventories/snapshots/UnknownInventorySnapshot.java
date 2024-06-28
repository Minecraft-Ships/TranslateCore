package org.core.inventory.inventories.snapshots;

import org.core.inventory.Inventory;
import org.core.inventory.InventorySnapshot;
import org.core.inventory.parts.Slot;
import org.core.inventory.parts.snapshot.SlotSnapshot;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnknownInventorySnapshot implements InventorySnapshot {

    private final Set<SlotSnapshot> slots = new HashSet<>();

    public UnknownInventorySnapshot() {

    }

    public UnknownInventorySnapshot(Inventory inventory) {
        this.slots.addAll(inventory.getItemSlots().map(Slot::createSnapshot).collect(Collectors.toList()));
    }

    public UnknownInventorySnapshot(Collection<? extends SlotSnapshot> collection) {
        this.slots.addAll(collection);
    }

    @Override
    @Deprecated
    public void apply() {
    }

    public Collection<SlotSnapshot> getSlotSnapshots() {
        return this.slots;
    }

    @Override
    public Stream<Slot> getItemSlots() {
        return this.slots.stream().map(t -> t);
    }

    @Override
    public Optional<Slot> getSlot(int slotPos) {
        return this.slots
                .stream()
                .filter(s -> s.getPosition().isPresent())
                .filter(s -> s.getPosition().get() == slotPos)
                .findAny()
                .map(t -> t);
    }

    @Override
    public UnknownInventorySnapshot createSnapshot() {
        return new UnknownInventorySnapshot(this);
    }

    @Override
    public int getSlotCount() {
        return this.slots.size();
    }
}
