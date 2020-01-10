package org.core.inventory.inventories.live.entity;

import org.core.inventory.inventories.general.entity.ZombieInventory;
import org.core.world.position.ExactPosition;

public interface LiveZombieInventory extends ZombieInventory, LiveEntityInventory {

    @Override
    default ExactPosition getPosition(){
        return LiveEntityInventory.super.getPosition();
    }
}
