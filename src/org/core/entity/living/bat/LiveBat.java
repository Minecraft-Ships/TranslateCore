package org.core.entity.living.bat;

import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

public interface LiveBat extends Bat, LiveEntity {

    @Override
    default EntityType<LiveBat, BatSnapshot> getType(){
        return Bat.super.getType();
    }
}
