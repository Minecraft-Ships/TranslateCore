package org.core.entity.living.hostile.undead.classic;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;

public interface ClassicZombieSnapshot extends ClassicZombie, EntitySnapshot<LiveClassicZombie> {

    default EntityType<LiveClassicZombie, ClassicZombieSnapshot> getType(){
        return ClassicZombie.super.getType();
    }
}
