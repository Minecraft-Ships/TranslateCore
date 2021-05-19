package org.core.entity.scene.droppeditem;

import org.core.entity.Entity;
import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.entity.ItemHoldingEntity;

import java.util.concurrent.TimeUnit;

public interface DroppedItem<E extends Entity<?>> extends ItemHoldingEntity<E> {

    int getPickupDelayTicks();
    DroppedItem<E> setPickupDelay(int ticks);
    DroppedItem<E> setPickupDelay(int time, TimeUnit unit);

    @Override
    DroppedItemSnapshot createSnapshot();

    @SuppressWarnings("unchecked")
    @Override
    default EntityType<LiveDroppedItem, DroppedItemSnapshot> getType() {
        return EntityTypes.DROPPED_ITEM.get();
    }

}
