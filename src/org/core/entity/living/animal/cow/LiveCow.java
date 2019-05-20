package org.core.entity.living.animal.cow;

import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

public interface LiveCow extends Cow, LiveEntity {

    @Override
    default EntityType<Cow, CowSnapshot> getType(){
        return Cow.super.getType();
    }
}
