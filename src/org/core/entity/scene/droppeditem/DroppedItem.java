package org.core.entity.scene.droppeditem;

import org.core.entity.ItemHoldingEntity;

import java.util.concurrent.TimeUnit;

public interface DroppedItem extends ItemHoldingEntity {

    int getPickupDelayTicks();
    DroppedItem setPickupDelay(int ticks);
    DroppedItem setPickupDelay(int time, TimeUnit unit);

}
