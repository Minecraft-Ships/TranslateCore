package org.core.entity.living.hostile.undead.classic;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;
import org.core.entity.EntityTypes;

public interface ClassicZombieSnapshot extends ClassicZombie, EntitySnapshot<ClassicZombie> {

    @Override
    default EntityType<ClassicZombie, ClassicZombieSnapshot> getType(){
        return EntityTypes.ZOMBIE;
    }

}
