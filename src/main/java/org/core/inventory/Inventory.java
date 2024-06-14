package org.core.inventory;

import org.core.inventory.parts.InventoryPart;
import org.core.inventory.parts.Slot;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Inventory {

    interface Parent extends Inventory {

        @Deprecated(forRemoval = true)
        default Set<InventoryPart> getFirstChildren() {
            return getParts().collect(Collectors.toSet());
        }

        Stream<InventoryPart> getParts();

        @Override
        default Optional<Slot> getSlot(int slotPos) {
            Optional<InventoryPart> opPart = this.getParts().filter(c -> c.getSlot(slotPos).isPresent()).findFirst();
            if (opPart.isEmpty()) {
                return Optional.empty();
            }
            return opPart.get().getSlot(slotPos);
        }

    }

    @Deprecated(forRemoval = true)
    default Set<Slot> getSlots() {
        return getItemSlots().collect(Collectors.toSet());
    }

    Stream<Slot> getItemSlots();

    Optional<Slot> getSlot(int slotPos);

    Inventory createSnapshot();

    default int getSlotCount() {
        return (int) getItemSlots().count();
    }
}
