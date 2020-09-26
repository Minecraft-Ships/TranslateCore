package org.core.inventory.parts;

import org.core.inventory.Inventory;

import java.util.Optional;

public interface InventoryPart extends Inventory {

    @Override
    default Optional<Slot> getSlot(int slotPos){
        return getSlots().stream().filter(s -> s.getPosition().isPresent()).filter(s -> s.getPosition().get() == slotPos).findFirst();
    }
}
