package org.core.entity.living;

import org.core.entity.Entity;
import org.core.entity.InventoryHoldingEntity;
import org.core.entity.ItemHoldingEntity;
import org.core.entity.LiveEntity;
import org.core.inventory.inventories.BasicEntityInventory;
import org.core.inventory.parts.ArmorPart;
import org.core.inventory.parts.Slot;

public interface ArmoredEntity<E extends Entity<?>> extends ItemHoldingEntity<E>, InventoryHoldingEntity<E> {

    @Override
    BasicEntityInventory<? extends LiveEntity> getInventory();

    default ArmorPart getArmor(){
        return getInventory().getArmor();
    }

    default Slot getHoldingItem(){
        return getInventory().getMainHoldingItem();
    }
}
