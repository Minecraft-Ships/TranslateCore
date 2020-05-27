package org.core.inventory.inventories.live.entity;

import org.core.inventory.inventories.general.entity.ZombieInventory;
import org.core.world.position.impl.sync.SyncExactPosition;

public interface LiveZombieInventory extends ZombieInventory, LiveEntityInventory {

    @Override
    default SyncExactPosition getPosition(){
        return LiveEntityInventory.super.getPosition();
    }
}
