package org.core.entity.living.hostile.undead.classic;

import org.core.entity.Entity;
import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.entity.living.hostile.undead.Zombie;

@SuppressWarnings("unchecked")
public interface ClassicZombie<E extends Entity> extends Zombie<E> {

    @Override
    default EntityType<LiveClassicZombie, ClassicZombieSnapshot> getType(){
        return EntityTypes.ZOMBIE;
    }
}
