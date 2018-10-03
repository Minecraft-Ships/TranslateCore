package org.core.inventory.parts.snapshot;

import org.core.inventory.item.ItemStack;
import org.core.inventory.parts.Slot;

import java.util.Optional;

public class SlotSnapshot implements InventoryPartSnapshot, Slot {

    protected Integer slotPos;
    protected ItemStack itemstack;

    public SlotSnapshot(Slot slot){
        this(slot.getPosition().orElse(null), slot.getItem().orElse(null));
    }

    public SlotSnapshot(Integer slotPos, ItemStack stack){
        this.slotPos = slotPos;
        this.itemstack = stack;
    }

    @Override
    public Optional<Integer> getPosition() {
        return Optional.ofNullable(this.slotPos);
    }

    @Override
    public Optional<ItemStack> getItem() {
        return Optional.ofNullable(itemstack);
    }

    @Override
    public SlotSnapshot setItem(ItemStack stack) {
        this.itemstack = stack;
        return this;
    }

    @Override
    public SlotSnapshot createSnapshot() {
        return new SlotSnapshot(this);
    }
}
