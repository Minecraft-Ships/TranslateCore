package org.core.entity.projectile.item.snowball;

import org.core.entity.projectile.ItemProjectileEntity;
import org.core.inventory.item.ItemStack;
import org.core.inventory.item.ItemTypes;

public interface SnowballEntity extends ItemProjectileEntity {

    default ItemStack getItem(){
        return ItemTypes.SNOWBALL.getDefaultItemStack().copyWithQuantity(1);
    }
}
