package org.core.entity.living.hostile.undead;

import org.core.entity.living.AgeableEntity;
import org.core.entity.living.ArmoredEntity;
import org.core.entity.living.hostile.HostileEntity;
import org.core.inventory.inventories.ZombieInventory;

public interface Zombie extends HostileEntity, ArmoredEntity, AgeableEntity {

    @Override
    public ZombieInventory getInventory();

}
