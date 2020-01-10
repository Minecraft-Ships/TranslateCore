package org.core.entity.living.animal.cow;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

@SuppressWarnings("unchecked")
public interface CowSnapshot extends Cow<EntitySnapshot<? extends LiveEntity>>, EntitySnapshot<LiveCow> {

    @Override
    default EntityType<LiveCow, CowSnapshot> getType(){
        return Cow.super.getType();
    }

}
