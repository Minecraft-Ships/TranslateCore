package org.core.inventory.inventories.snapshots.entity;

import org.core.entity.Entity;
import org.core.inventory.InventorySnapshot;
import org.core.inventory.inventories.BasicEntityInventory;

public interface EntityInventorySnapshot <E extends Entity> extends InventorySnapshot, BasicEntityInventory<E> {

    void apply(E entity);

    @Override
    default void apply() {
        apply(this.getAttachedEntity());
    }
}
