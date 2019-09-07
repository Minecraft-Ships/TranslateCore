package org.core.inventory.inventories.snapshots.entity;

import org.core.entity.LiveEntity;
import org.core.inventory.InventorySnapshot;
import org.core.inventory.inventories.BasicEntityInventory;

public interface EntityInventorySnapshot <E extends LiveEntity> extends InventorySnapshot, BasicEntityInventory<E> {

    void apply(E entity);

    @Override
    default void apply() {
        getAttachedEntity().ifPresent(e -> apply(e));
    }
}
