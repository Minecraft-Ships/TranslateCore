package org.core.entity.scene.itemframe;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;

public interface ItemFrameSnapshot extends ItemFrame, EntitySnapshot<ItemFrame> {

    @Override
    default EntityType<ItemFrame, ItemFrameSnapshot> getType(){
        return ItemFrame.super.getType();
    }
}
