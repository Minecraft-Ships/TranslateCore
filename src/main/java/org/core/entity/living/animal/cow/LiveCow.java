package org.core.entity.living.animal.cow;

import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

@SuppressWarnings("unchecked")
public interface LiveCow extends Cow<LiveEntity>, LiveEntity {

    @SuppressWarnings("override")
    default EntityType<LiveCow, CowSnapshot> getType(){
        return Cow.super.getType();
    }

}
