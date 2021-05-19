package org.core.entity.scene.itemframe;

import org.core.entity.Entity;
import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.entity.ItemHoldingEntity;
import org.core.entity.scene.AttachableEntity;
import org.core.exceptions.DirectionNotSupported;
import org.core.inventory.item.stack.ItemStack;
import org.core.world.direction.Direction;

public interface ItemFrame<E extends Entity<?>> extends AttachableEntity<E>, ItemHoldingEntity<E> {

    void setItem(ItemStack stack);
    Direction getItemRotation();
    boolean getItemRotationFlip();
    ItemFrame<E> setItemRotation(Direction direction, boolean flip) throws DirectionNotSupported;

    @Override
    default EntityType<LiveItemFrame, ItemFrameSnapshot> getType() {
        return EntityTypes.ITEM_FRAME.get();
    }


}
