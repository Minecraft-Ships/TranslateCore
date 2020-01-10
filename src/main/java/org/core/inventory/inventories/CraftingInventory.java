package org.core.inventory.inventories;

import org.core.inventory.Inventory;
import org.core.inventory.parts.CraftGrid;
import org.core.inventory.parts.InventoryPart;
import org.core.inventory.parts.Slot;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface CraftingInventory extends Inventory.Parent, BlockAttachedInventory {

    CraftGrid getCraftingGrid();
    Slot getResult();

    @Override
    default Set<InventoryPart> getFirstChildren(){
        return new HashSet<>(Arrays.asList(getCraftingGrid(), getResult()));
    }
}
