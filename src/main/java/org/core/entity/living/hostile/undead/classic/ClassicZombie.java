package org.core.entity.living.hostile.undead.classic;

import org.core.entity.Entity;
import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.entity.LiveEntity;
import org.core.entity.living.hostile.undead.Zombie;
import org.core.inventory.inventories.general.entity.ZombieInventory;

public interface ClassicZombie<E extends Entity<?>> extends Zombie<E> {

    ZombieInventory<LiveClassicZombie> getInventory();

    @Override
    default EntityType<LiveClassicZombie, ClassicZombieSnapshot> getType(){
        return EntityTypes.ZOMBIE.get();
    }
}
