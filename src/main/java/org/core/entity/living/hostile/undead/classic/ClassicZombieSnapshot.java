package org.core.entity.living.hostile.undead.classic;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

@SuppressWarnings("unchecked")
public interface ClassicZombieSnapshot extends ClassicZombie<EntitySnapshot<? extends LiveEntity>>, EntitySnapshot<LiveClassicZombie> {

    @SuppressWarnings("override")
    default EntityType<LiveClassicZombie, ClassicZombieSnapshot> getType(){
        return ClassicZombie.super.getType();
    }
}
