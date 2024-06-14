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
import java.util.function.Supplier;
import java.util.stream.Stream;

public interface FurnaceInventory extends BlockAttachedInventory, Inventory.Parent {

    Slot getFuelSlot();

    Slot getResultsSlot();

    Slot getSmeltingSlot();

    @Override
    default BlockType[] getAllowedBlockType() {
        return new BlockType[]{BlockTypes.FURNACE};
    }

    @Override
    default Stream<InventoryPart> getParts() {
        return this.getItemSlots().map(slot -> slot);
    }

    @Override
    default Stream<Slot> getItemSlots() {
        return Stream
                .<Supplier<Slot>>of(this::getFuelSlot, this::getResultsSlot, this::getSmeltingSlot)
                .map(Supplier::get);
    }

    @Override
    FurnaceInventorySnapshot createSnapshot();
}
