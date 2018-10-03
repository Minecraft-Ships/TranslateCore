package org.core.inventory.inventories;

import org.core.inventory.inventories.snapshots.PlayerInventorySnapshot;
import org.core.inventory.parts.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface PlayerInventory extends BasicEntityInventory, EntityAttachedInventory {

    public Hotbar getHotbar();
    public Grid2x2 getCraftingGrid();
    public MainPlayerInventory getMainInventory();

    @Override
    public PlayerInventorySnapshot createSnapshot();

    @Override
    default Slot getMainHoldingItem(){
        return getHotbar().getSelectedSlot();
    }

    @Override
    public default Set<InventoryPart> getFirstChildren(){
        return new HashSet<>(Arrays.asList(getArmor(), getOffHoldingItem(), getCraftingGrid(), getMainInventory(), getHotbar()));
    }
}
