package org.core.inventory;

import org.core.world.position.BlockPosition;
import org.core.world.position.ExactPosition;

public interface LiveInventory extends PositionableInventory {

    interface LiveExactInventory extends LiveInventory {

        @Override
        public ExactPosition getPosition();

    }

    interface LiveBlockInventory extends LiveInventory{

        @Override
        public BlockPosition getPosition();
    }
}
