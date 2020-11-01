package org.core.entity.living.hostile.undead;

import org.core.entity.Entity;
import org.core.entity.LiveEntity;
import org.core.entity.living.AgeableEntity;
import org.core.entity.living.ArmoredEntity;
import org.core.entity.living.hostile.HostileEntity;
import org.core.inventory.inventories.general.entity.ZombieInventory;

public interface Zombie<E extends Entity<?>> extends HostileEntity<E>, ArmoredEntity<E>, AgeableEntity<E> {

    @Override
    ZombieInventory<? extends Zombie<LiveEntity>> getInventory();

}
