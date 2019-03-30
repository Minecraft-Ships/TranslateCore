package org.core.inventory.inventories.live.entity;

import org.core.entity.LiveEntity;
import org.core.inventory.LiveInventory;
import org.core.inventory.inventories.BasicEntityInventory;
import org.core.world.position.ExactPosition;

public interface LiveEntityInventory extends BasicEntityInventory, LiveInventory.ExactPostionableInventory {

    LiveEntity getAttachedEntity();

    @Override
    default ExactPosition getPosition(){
        return getAttachedEntity().getPosition();
    }
}
