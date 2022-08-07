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
    default Set<Slot> getSlots() {
        Set<Slot> slots = new HashSet<>();
        slots.addAll(this.getHotbar().getSlots());
        slots.addAll(this.getMainInventory().getSlots());
        slots.addAll(this.getArmor().getSlots());
        slots.add(this.getOffHoldingItem());
        slots.addAll(this.getCraftingGrid().getSlots());
        return slots;
    }

    @Override
    PlayerInventorySnapshot createSnapshot();

    @Override
    default Slot getMainHoldingItem() {
        return this.getHotbar().getSelectedSlot();
    }

    @Override
    default Set<InventoryPart> getFirstChildren() {
        return new HashSet<>(Arrays.asList(
                this.getArmor(),
                this.getOffHoldingItem(),
                this.getCraftingGrid(),
                this.getMainInventory(),
                this.getHotbar()));
    }
}
