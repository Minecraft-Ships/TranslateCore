package org.core.entity.scene.itemframe;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

@SuppressWarnings("unchecked")
public interface ItemFrameSnapshot extends ItemFrame<EntitySnapshot<? extends LiveEntity>>, EntitySnapshot<LiveItemFrame> {

    @Override
    default EntityType<LiveItemFrame, ItemFrameSnapshot> getType(){
        return ItemFrame.super.getType();
    }
}
