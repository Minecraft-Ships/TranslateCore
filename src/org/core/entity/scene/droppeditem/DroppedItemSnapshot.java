package org.core.entity.scene.droppeditem;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;
import org.core.inventory.parts.snapshot.SlotSnapshot;

public interface DroppedItemSnapshot extends DroppedItem, EntitySnapshot<LiveDroppedItem> {

    @Override
    SlotSnapshot getHoldingItem();

    @Override
    default EntityType<LiveDroppedItem, DroppedItemSnapshot> getType(){
        return DroppedItem.super.getType();
    }
}
