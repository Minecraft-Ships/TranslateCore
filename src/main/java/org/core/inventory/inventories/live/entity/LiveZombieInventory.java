package org.core.inventory.inventories.live.entity;

import org.core.entity.LiveEntity;
import org.core.entity.living.hostile.undead.Zombie;
import org.core.inventory.inventories.general.entity.ZombieInventory;
import org.core.world.position.impl.sync.SyncExactPosition;

public interface LiveZombieInventory<Z extends Zombie<LiveEntity> & LiveEntity> extends ZombieInventory<Z>,
        LiveEntityInventory<Z> {

    @Override
    default SyncExactPosition getPosition() {
        return LiveEntityInventory.super.getPosition();
    }
}
