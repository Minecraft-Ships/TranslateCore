package org.core.entity.living.animal.cow;

import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.entity.living.animal.AnimalEntity;

public interface Cow extends AnimalEntity {

    @Override
    default EntityType<LiveCow, CowSnapshot> getType(){
        return EntityTypes.COW;
    }

}
