package org.core.entity.projectile;

import org.core.entity.Entity;
import org.core.inventory.item.stack.ItemStack;

public interface ItemProjectileEntity<E extends Entity<?>> extends ProjectileEntity<E> {

    ItemStack getItem();
}
