package org.core.inventory.inventories.snapshots.entity;

import org.core.entity.living.hostile.undead.classic.ClassicZombie;
import org.core.entity.living.hostile.undead.classic.LiveClassicZombie;
import org.core.inventory.inventories.general.entity.ZombieInventory;
import org.core.inventory.parts.ArmorPart;
import org.core.inventory.parts.Slot;
import org.core.world.position.impl.sync.SyncExactPosition;

import java.util.Optional;

public abstract class ZombieInventorySnapshot implements ZombieInventory<LiveClassicZombie>, EntityInventorySnapshot<LiveClassicZombie> {

    protected ArmorPart armorPart;
    protected Slot mainHoldingItem;
    protected Slot secondHoldingItem;
    protected LiveClassicZombie zombie;

    public ZombieInventorySnapshot(ZombieInventory<? extends ClassicZombie> inv){
        this.armorPart = inv.getArmor().createSnapshot();
        this.mainHoldingItem = inv.getMainHoldingItem().createSnapshot();
        this.secondHoldingItem = inv.getOffHoldingItem().createSnapshot();
        this.zombie = (LiveClassicZombie) inv.getAttachedEntity().get();
    }

    @Override
    public SyncExactPosition getPosition(){
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
    public Optional<LiveClassicZombie> getAttachedEntity(){
        return Optional.of(this.zombie);
    }
}
