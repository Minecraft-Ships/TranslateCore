package org.core.inventory.inventories.general.block;

import org.core.inventory.Inventory;
import org.core.inventory.inventories.BlockAttachedInventory;
import org.core.inventory.inventories.snapshots.block.FurnaceInventorySnapshot;
import org.core.inventory.parts.InventoryPart;
import org.core.inventory.parts.Slot;
import org.core.world.position.block.BlockType;
import org.core.world.position.block.BlockTypes;

import java.util.HashSet;
import java.util.Set;

public interface FurnaceInventory extends BlockAttachedInventory, Inventory.Parent {

    Slot getFuelSlot();

    Slot getResultsSlot();

    Slot getSmeltingSlot();

    @Override
    default BlockType[] getAllowedBlockType() {
        return new BlockType[]{BlockTypes.FURNACE};
    }

    @Override
    default Set<InventoryPart> getFirstChildren() {
        Set<InventoryPart> set = new HashSet<>();
        set.add(getFuelSlot());
        set.add(getResultsSlot());
        return set;
    }

    @Override
    default Set<Slot> getSlots() {
        Set<Slot> slots = new HashSet<>();
        slots.add(getFuelSlot());
        slots.add(getResultsSlot());
        slots.add(getSmeltingSlot());
        return slots;
    }

    @Override
    FurnaceInventorySnapshot createSnapshot();
}
