package org.core.inventory.inventories;

import org.core.inventory.Inventory;
import org.core.inventory.parts.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface PlayerInventory extends Inventory {

    public Slot getOffHandSlot();
    public ArmorPart getArmor();
    public Hotbar getHotbar();
    public Grid2x2 getCraftingGrid();
    public MainPlayerInventory getMainInventory();

    @Override
    public default Set<InventoryPart> getFirstChildren(){
        return new HashSet<>(Arrays.asList(getArmor(), getOffHandSlot(), getCraftingGrid(), getMainInventory(), getHotbar()));
    }
}
