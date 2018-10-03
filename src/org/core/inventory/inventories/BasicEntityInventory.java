package org.core.inventory.inventories;

import org.core.inventory.Inventory;
import org.core.inventory.parts.ArmorPart;
import org.core.inventory.parts.InventoryPart;
import org.core.inventory.parts.Slot;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface BasicEntityInventory extends Inventory {

    public ArmorPart getArmor();
    public Slot getMainHoldingItem();
    public Slot getOffHoldingItem();

    @Override
    public default Set<InventoryPart> getFirstChildren(){
        return new HashSet<>(Arrays.asList(getArmor(), getMainHoldingItem(), getOffHoldingItem()));
    }
}
