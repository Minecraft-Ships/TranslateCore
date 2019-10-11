package org.core.entity.scene.droppeditem;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;
import org.core.entity.LiveEntity;
import org.core.inventory.parts.snapshot.SlotSnapshot;

public interface DroppedItemSnapshot extends DroppedItem<EntitySnapshot<? extends LiveEntity>>, EntitySnapshot<LiveDroppedItem> {

    @Override
    SlotSnapshot getHoldingItem();

    @SuppressWarnings("unchecked")
    @Override
    default EntityType<LiveDroppedItem, DroppedItemSnapshot> getType(){
        return DroppedItem.super.getType();
    }
}
