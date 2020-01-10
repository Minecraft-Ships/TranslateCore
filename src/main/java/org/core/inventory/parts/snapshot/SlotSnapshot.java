package org.core.inventory.parts.snapshot;

import org.core.inventory.item.stack.ItemStack;
import org.core.inventory.item.stack.ItemStackSnapshot;
import org.core.inventory.parts.Slot;

import java.util.Optional;

public class SlotSnapshot implements InventoryPartSnapshot, Slot {

    protected Integer slotPos;
    protected ItemStackSnapshot itemstack;

    public SlotSnapshot(Slot slot){
        this(slot.getPosition().orElse(null), slot.getItem().orElse(null));
    }

    public SlotSnapshot(Integer slotPos, ItemStack stack){
        this.slotPos = slotPos;
        if(stack != null) {
            this.itemstack = stack.createSnapshot();
        }
    }

    @Override
    public Optional<Integer> getPosition() {
        return Optional.ofNullable(this.slotPos);
    }

    @Override
    public Optional<ItemStack> getItem() {
        return Optional.ofNullable(this.itemstack);
    }

    @Override
    public SlotSnapshot setItem(ItemStack stack) {
        this.itemstack = stack.createSnapshot();
        return this;
    }

    @Override
    public SlotSnapshot createSnapshot() {
        return new SlotSnapshot(this);
    }
}
