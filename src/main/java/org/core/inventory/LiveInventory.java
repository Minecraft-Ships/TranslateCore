package org.core.inventory;

import org.core.world.position.impl.Position;
import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.impl.sync.SyncExactPosition;

public interface LiveInventory<S extends Position<?>> extends PositionableInventory<S> {

    interface LiveExactInventory extends LiveInventory<SyncExactPosition> {

    }

    interface LiveBlockInventory extends LiveInventory<SyncBlockPosition> {
    }
}
