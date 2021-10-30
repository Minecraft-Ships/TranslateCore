package org.core.inventory;

import org.core.world.position.Positionable;
import org.core.world.position.impl.Position;
import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.impl.sync.SyncExactPosition;

public interface PositionableInventory<N extends Position<?>> extends Inventory, Positionable<N> {

    interface ExactPositionableInventory extends PositionableInventory<SyncExactPosition> {

    }

    interface BlockPositionableInventory extends PositionableInventory<SyncBlockPosition> {

    }
}
