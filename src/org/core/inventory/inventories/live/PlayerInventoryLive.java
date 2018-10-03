package org.core.inventory.inventories.live;

import org.core.inventory.LiveInventory;
import org.core.inventory.inventories.PlayerInventory;
import org.core.world.position.ExactPosition;

public interface PlayerInventoryLive extends PlayerInventory, LiveInventory.ExactPostionableInventory {

    @Override
    default ExactPosition getPosition(){
        return PlayerInventory.super.getPosition();
    }
}
