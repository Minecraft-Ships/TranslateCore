package org.core.entity.scene.droppeditem;

import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

public interface LiveDroppedItem extends DroppedItem<LiveEntity>, LiveEntity {

    @Override
    default EntityType<LiveDroppedItem, DroppedItemSnapshot> getType(){
        return DroppedItem.super.getType();
    }
}
