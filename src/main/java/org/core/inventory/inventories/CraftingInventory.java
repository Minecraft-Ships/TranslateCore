package org.core.inventory.inventories;

import org.core.inventory.Inventory;
import org.core.inventory.parts.CraftGrid;
import org.core.inventory.parts.InventoryPart;
import org.core.inventory.parts.Slot;

import java.util.function.Supplier;
import java.util.stream.Stream;

public interface CraftingInventory extends Inventory.Parent, BlockAttachedInventory {

    CraftGrid getCraftingGrid();

    Slot getResult();

    @Override
    default Stream<InventoryPart> getParts() {
        return Stream.<Supplier<? extends InventoryPart>>of(this::getCraftingGrid, this::getResult).map(Supplier::get);
    }
}
