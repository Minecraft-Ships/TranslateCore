package org.core.entity.living.hostile.undead.classic;

import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

public interface LiveClassicZombie extends ClassicZombie, LiveEntity {

    @Override
    default EntityType<ClassicZombie, ClassicZombieSnapshot> getType(){
        return ClassicZombie.super.getType();
    }
}
