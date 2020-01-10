package org.core.inventory.parts;

import org.core.inventory.item.stack.ItemStack;
import org.core.inventory.parts.snapshot.SlotSnapshot;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public interface Slot extends InventoryPart {

    Optional<Integer> getPosition();
    Optional<ItemStack> getItem();
    Slot setItem(ItemStack stack);

    @Override
    default SlotSnapshot createSnapshot(){
        return new SlotSnapshot(this);
    }

    @Override
    default Set<Slot> getSlots(){
        return new HashSet<>(Arrays.asList(this));
    }
}
