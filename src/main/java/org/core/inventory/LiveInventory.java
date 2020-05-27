package org.core.inventory;

import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.impl.sync.SyncExactPosition;

public interface LiveInventory extends PositionableInventory {

    interface LiveExactInventory extends LiveInventory {

        @Override
        public SyncExactPosition getPosition();

    }

    interface LiveBlockInventory extends LiveInventory{

        @Override
        public SyncBlockPosition getPosition();
    }
}
