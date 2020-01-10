package org.core.inventory;

import org.core.world.position.BlockPosition;
import org.core.world.position.ExactPosition;
import org.core.world.position.Positionable;

public interface PositionableInventory extends Inventory, Positionable {

    interface ExactPostionableInventory extends PositionableInventory {

        @Override
        ExactPosition getPosition();

    }

    interface BlockPositionableInventory extends PositionableInventory {

        @Override
        BlockPosition getPosition();

    }
}
