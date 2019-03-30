package org.core.inventory.inventories;

import org.core.entity.Entity;
import org.core.inventory.Inventory;
import org.core.inventory.parts.ArmorPart;
import org.core.inventory.parts.InventoryPart;
import org.core.inventory.parts.Slot;
import org.core.world.position.ExactPosition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface BasicEntityInventory<E extends Entity> extends Inventory {

    ArmorPart getArmor();
    Slot getMainHoldingItem();
    Slot getOffHoldingItem();
    ExactPosition getPosition();
    E getAttachedEntity();

    @Override
    default Set<InventoryPart> getFirstChildren(){
        return new HashSet<>(Arrays.asList(getArmor(), getMainHoldingItem(), getOffHoldingItem()));
    }
}
