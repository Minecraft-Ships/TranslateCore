package org.core.entity.projectile;

import org.core.entity.Entity;
import org.core.inventory.item.ItemStack;

public interface ItemProjectileEntity<E extends Entity> extends ProjectileEntity<E> {

    ItemStack getItem();
}
