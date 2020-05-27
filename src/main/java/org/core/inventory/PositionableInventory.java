package org.core.inventory;

import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.impl.sync.SyncExactPosition;
import org.core.world.position.Positionable;

public interface PositionableInventory extends Inventory, Positionable {

    interface ExactPostionableInventory extends PositionableInventory {

        @Override
        SyncExactPosition getPosition();

    }

    interface BlockPositionableInventory extends PositionableInventory {

        @Override
        SyncBlockPosition getPosition();

    }
}
