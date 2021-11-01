package org.core.inventory.inventories.snapshots.entity;

import org.core.entity.LiveEntity;
import org.core.entity.living.hostile.undead.Zombie;
import org.core.inventory.inventories.BasicEntityInventory;
import org.core.inventory.inventories.general.entity.ZombieInventory;
import org.core.inventory.parts.ArmorPart;
import org.core.inventory.parts.Slot;
import org.core.world.position.impl.sync.SyncExactPosition;

import java.util.Optional;

public abstract class ZombieInventorySnapshot<Z extends Zombie<LiveEntity> & LiveEntity> implements ZombieInventory<Z>,
        EntityInventorySnapshot<Z> {

    protected ArmorPart armorPart;
    protected Slot mainHoldingItem;
    protected Slot secondHoldingItem;
    protected Z zombie;

    public ZombieInventorySnapshot(BasicEntityInventory<? extends Z> inv) {
        this.armorPart = inv.getArmor().createSnapshot();
        this.mainHoldingItem = inv.getMainHoldingItem().createSnapshot();
        this.secondHoldingItem = inv.getOffHoldingItem().createSnapshot();
        this.zombie = inv.getAttachedEntity().orElseThrow(() -> new IllegalStateException("Could " +
                "not find attached entity"));
    }

    @Override
    public SyncExactPosition getPosition() {
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
    public Slot getOffHoldingItem() {
        return this.secondHoldingItem;
    }

    @Override
    public Optional<Z> getAttachedEntity() {
        return Optional.of(this.zombie);
    }
}
