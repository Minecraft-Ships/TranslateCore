package org.core.entity.living.animal.cow;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;

public interface CowSnapshot extends Cow, EntitySnapshot<Cow> {

    @Override
    default EntityType<Cow, CowSnapshot> getType(){
        return Cow.super.getType();
    }
}
