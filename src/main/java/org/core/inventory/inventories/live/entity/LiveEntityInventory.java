package org.core.inventory.inventories.live.entity;

import org.core.entity.LiveEntity;
import org.core.inventory.LiveInventory;
import org.core.inventory.inventories.BasicEntityInventory;
import org.core.world.position.impl.sync.SyncExactPosition;

import java.util.Optional;

public interface LiveEntityInventory<E extends LiveEntity> extends BasicEntityInventory<E>, LiveInventory.ExactPostionableInventory {

    Optional<E> getAttachedEntity();

    @Override
    default SyncExactPosition getPosition(){
        return getAttachedEntity().get().getPosition();
    }
}
