package org.core.inventory.inventories.live.entity;

import org.core.entity.LiveEntity;
import org.core.inventory.PositionableInventory;
import org.core.inventory.inventories.BasicEntityInventory;
import org.core.world.position.impl.sync.SyncExactPosition;

import java.util.Optional;

public interface LiveEntityInventory<E extends LiveEntity>
        extends BasicEntityInventory<E>, PositionableInventory.ExactPositionableInventory {

    @Override
    default SyncExactPosition getPosition() {
        return this
                .getAttachedEntity()
                .orElseThrow(() -> new IllegalStateException("Cannot get attached entity"))
                .getPosition();
    }

    @Override
    Optional<E> getAttachedEntity();
}
