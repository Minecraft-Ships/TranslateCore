package org.core.inventory.inventories.utils;

import org.core.entity.Entity;
import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;
import org.core.inventory.Inventory;

public interface EntityAttachedInventory <E extends Entity, T extends EntityType<E>, S extends EntitySnapshot<E, T>> extends Inventory {

    public S getAttachedEntity();
}
