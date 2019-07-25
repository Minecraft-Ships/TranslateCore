package org.core.entity.living.bat;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;

public interface BatSnapshot extends Bat, EntitySnapshot<LiveBat> {

    default EntityType<LiveBat, BatSnapshot> getType(){
        return Bat.super.getType();
    }
}
