package org.core.entity.living.bat;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

@SuppressWarnings("unchecked")
public interface BatSnapshot extends Bat<EntitySnapshot<? extends LiveEntity>>, EntitySnapshot<LiveBat> {

    default EntityType<LiveBat, BatSnapshot> getType(){
        return Bat.super.getType();
    }
}
