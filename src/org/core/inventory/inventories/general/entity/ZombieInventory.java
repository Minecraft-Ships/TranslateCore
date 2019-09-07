package org.core.inventory.inventories.general.entity;

import org.core.entity.LiveEntity;
import org.core.entity.living.hostile.undead.Zombie;
import org.core.inventory.inventories.BasicEntityInventory;
import org.core.inventory.inventories.snapshots.entity.ZombieInventorySnapshot;
import org.core.inventory.parts.Slot;

import java.util.HashSet;
import java.util.Set;

public interface ZombieInventory<Z extends Zombie<LiveEntity> & LiveEntity> extends BasicEntityInventory<Z> {

    @Override
    ZombieInventorySnapshot createSnapshot();

    @Override
    default Set<Slot> getSlots(){
        Set<Slot> slots = new HashSet<>();
        slots.addAll(this.getArmor().getSlots());
        slots.add(this.getMainHoldingItem());
        slots.add(this.getOffHoldingItem());
        return slots;
    }
}
