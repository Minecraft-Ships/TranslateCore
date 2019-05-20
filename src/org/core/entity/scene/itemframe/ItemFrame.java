package org.core.entity.scene.itemframe;

import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.entity.ItemHoldingEntity;
import org.core.entity.scene.AttachableEntity;
import org.core.exceptions.DirectionNotSupported;
import org.core.world.direction.Direction;

public interface ItemFrame extends AttachableEntity, ItemHoldingEntity {

    Direction getItemRotation();
    boolean getItemRotationFlip();
    ItemFrame setItemRotation(Direction direction, boolean flip) throws DirectionNotSupported;

    @Override
    default EntityType<ItemFrame, ItemFrameSnapshot> getType() {
        return EntityTypes.ITEM_FRAME;
    }

}
