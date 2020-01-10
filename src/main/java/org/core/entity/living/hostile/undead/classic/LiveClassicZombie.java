package org.core.entity.living.hostile.undead.classic;

import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

@SuppressWarnings("unchecked")
public interface LiveClassicZombie extends ClassicZombie<LiveEntity>, LiveEntity {

    default EntityType<LiveClassicZombie, ClassicZombieSnapshot> getType(){
        return ClassicZombie.super.getType();
    }
}
