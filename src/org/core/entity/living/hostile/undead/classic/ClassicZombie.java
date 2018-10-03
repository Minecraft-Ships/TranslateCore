package org.core.entity.living.hostile.undead.classic;

import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.entity.living.hostile.undead.Zombie;

public interface ClassicZombie extends Zombie {

    @Override
    public default EntityType<ClassicZombie, ClassicZombieSnapshot> getType(){
        return EntityTypes.ZOMBIE;
    }
}
