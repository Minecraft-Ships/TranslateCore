package org.core.inventory;

import org.core.inventory.parts.InventoryPart;
import org.core.inventory.parts.Slot;

import java.util.Optional;
import java.util.Set;

public interface Inventory {

    public Set<InventoryPart> getFirstChildren();
    public Optional<Slot> getSlot(int pos);
    public Inventory copy();
}
