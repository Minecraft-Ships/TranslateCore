package org.core.entity.living;

import org.core.inventory.inventories.BasicEntityInventory;
import org.core.inventory.parts.ArmorPart;
import org.core.inventory.parts.Slot;

public interface ArmoredEntity extends ItemHoldingEntity, InventoryHoldingEntity {

    @Override
    public BasicEntityInventory getInventory();

    public default ArmorPart getArmor(){
        return getInventory().getArmor();
    }

    public default Slot getHoldingItem(){
        return getInventory().getMainHoldingItem();
    }
}
