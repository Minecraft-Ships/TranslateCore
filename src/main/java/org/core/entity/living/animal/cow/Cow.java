package org.core.entity.living.animal.cow;

import org.core.entity.Entity;
import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.entity.living.animal.AnimalEntity;

@SuppressWarnings("unchecked")
public interface Cow<E extends Entity<?>> extends AnimalEntity<E> {

    @Override
    default EntityType<LiveCow, CowSnapshot> getType(){
        return EntityTypes.COW.get();
    }

}
