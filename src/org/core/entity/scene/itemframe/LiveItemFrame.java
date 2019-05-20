package org.core.entity.scene.itemframe;

import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

public interface LiveItemFrame extends ItemFrame, LiveEntity {

    @Override
    default EntityType<ItemFrame, ItemFrameSnapshot> getType(){
        return ItemFrame.super.getType();
    }
}
