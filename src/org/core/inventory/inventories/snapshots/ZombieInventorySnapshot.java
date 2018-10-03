package org.core.inventory.inventories.snapshots;

import org.core.inventory.inventories.ZombieInventory;
import org.core.inventory.parts.ArmorPart;
import org.core.inventory.parts.Slot;

public abstract class ZombieInventorySnapshot implements ZombieInventory, EntityInventorySnapshot {

    ArmorPart armorPart;
    Slot mainHoldingItem;
    Slot secondHoldingItem;

    public ZombieInventorySnapshot(ZombieInventory inv){
        this.armorPart = inv.getArmor().createSnapshot();
        this.mainHoldingItem = inv.getMainHoldingItem().createSnapshot();
        this.secondHoldingItem = inv.getOffHoldingItem().createSnapshot();
    }

    @Override
    public ArmorPart getArmor() {
        return this.armorPart;
    }

    @Override
    public Slot getMainHoldingItem() {
        return this.mainHoldingItem;
    }

    @Override
    public Slot getOffHoldingItem(){
        return this.secondHoldingItem;
    }
}
