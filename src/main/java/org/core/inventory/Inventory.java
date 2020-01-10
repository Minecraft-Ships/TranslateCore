package org.core.inventory;

import org.core.inventory.parts.InventoryPart;
import org.core.inventory.parts.Slot;

import java.util.Optional;
import java.util.Set;

public interface Inventory {

    interface Parent extends Inventory {

        Set<InventoryPart> getFirstChildren();

        @Override
        default Optional<Slot> getSlot(int slotPos){
            Optional<InventoryPart> opPart = getFirstChildren().stream().filter(c -> c.getSlot(slotPos).isPresent()).findFirst();
            if(!opPart.isPresent()){
                return Optional.empty();
            }
            return opPart.get().getSlot(slotPos);
        }

    }

    Set<Slot> getSlots();
    Optional<Slot> getSlot(int slotPos);
    Inventory createSnapshot();

    default int getSlotCount(){
        return getSlots().size();
    }
}
