package org.core.inventory.inventories.snapshots.entity;

import org.core.entity.living.hostile.undead.classic.ClassicZombie;
import org.core.entity.living.hostile.undead.classic.ClassicZombieSnapshot;
import org.core.inventory.inventories.general.entity.ZombieInventory;
import org.core.inventory.parts.ArmorPart;
import org.core.inventory.parts.Slot;
import org.core.world.position.ExactPosition;

public abstract class ZombieInventorySnapshot implements ZombieInventory<ClassicZombie>, EntityInventorySnapshot<ClassicZombie> {

    protected ArmorPart armorPart;
    protected Slot mainHoldingItem;
    protected Slot secondHoldingItem;
    protected ClassicZombieSnapshot zombie;

    public ZombieInventorySnapshot(ZombieInventory<? extends ClassicZombie> inv){
        this.armorPart = inv.getArmor().createSnapshot();
        this.mainHoldingItem = inv.getMainHoldingItem().createSnapshot();
        this.secondHoldingItem = inv.getOffHoldingItem().createSnapshot();
        this.zombie = (ClassicZombieSnapshot) inv.getAttachedEntity().createSnapshot();
    }

    @Override
    public ExactPosition getPosition(){
        return this.zombie.getPosition();
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

    @Override
    public ClassicZombieSnapshot getAttachedEntity(){
        return this.zombie;
    }
}
