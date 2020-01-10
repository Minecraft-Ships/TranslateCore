package org.core.inventory.inventories.general.entity;

import org.core.entity.living.human.player.LivePlayer;
import org.core.inventory.inventories.BasicEntityInventory;
import org.core.inventory.inventories.snapshots.entity.PlayerInventorySnapshot;
import org.core.inventory.parts.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface PlayerInventory extends BasicEntityInventory<LivePlayer> {

    Hotbar getHotbar();
    Grid2x2 getCraftingGrid();
    MainPlayerInventory getMainInventory();

    @Override
    default Set<Slot> getSlots(){
        Set<Slot> slots = new HashSet<>();
        slots.addAll(getHotbar().getSlots());
        slots.addAll(getMainInventory().getSlots());
        slots.addAll(getArmor().getSlots());
        slots.add(getOffHoldingItem());
        slots.addAll(getCraftingGrid().getSlots());
        return slots;
    }

    @Override
    PlayerInventorySnapshot createSnapshot();

    @Override
    default Slot getMainHoldingItem(){
        return getHotbar().getSelectedSlot();
    }

    @Override
    default Set<InventoryPart> getFirstChildren(){
        return new HashSet<>(Arrays.asList(getArmor(), getOffHoldingItem(), getCraftingGrid(), getMainInventory(), getHotbar()));
    }
}
