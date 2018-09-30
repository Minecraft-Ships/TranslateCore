package org.core.inventory.parts;

import java.util.Optional;
import java.util.Set;

public interface InventoryPart {

    public Set<Slot> getSlots();
    public int[] getSlotRange();

    public default Optional<Slot> getSlot(int slotPos){
        return getSlots().stream().filter(s -> s.getPosition().isPresent()).filter(s -> s.getPosition().get() == slotPos).findFirst();
    }
}
