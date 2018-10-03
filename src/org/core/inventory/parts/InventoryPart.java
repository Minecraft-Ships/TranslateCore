package org.core.inventory.parts;

import org.core.inventory.parts.snapshot.InventoryPartSnapshot;

import java.util.Optional;
import java.util.Set;

public interface InventoryPart {

    public Set<Slot> getSlots();
    public InventoryPartSnapshot createSnapshot();


    public default Optional<Slot> getSlot(int slotPos){
        return getSlots().stream().filter(s -> s.getPosition().isPresent()).filter(s -> s.getPosition().get() == slotPos).findFirst();
    }
}
