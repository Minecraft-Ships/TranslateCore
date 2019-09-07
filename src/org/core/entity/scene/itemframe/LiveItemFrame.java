package org.core.entity.scene.itemframe;

import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

@SuppressWarnings("unchecked")
public interface LiveItemFrame extends ItemFrame<LiveEntity>, LiveEntity {

    @Override
    default EntityType<LiveItemFrame, ItemFrameSnapshot> getType(){
        return ItemFrame.super.getType();
    }

}
