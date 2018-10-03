package org.core.inventory.inventories;

import org.core.entity.Entity;
import org.core.inventory.PositionableInventory;
import org.core.world.position.ExactPosition;

public interface EntityAttachedInventory <E extends Entity> extends PositionableInventory.ExactPostionableInventory, BasicEntityInventory {

    public E getAttachedEntity();

    @Override
    default ExactPosition getPosition(){
        return this.getAttachedEntity().getPosition();
    }
}
