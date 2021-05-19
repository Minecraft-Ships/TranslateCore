package org.core.entity.living.animal.chicken;

import org.core.entity.Entity;
import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.entity.living.animal.AnimalEntity;

public interface Chicken<E extends Entity<?>> extends AnimalEntity<E> {

    @SuppressWarnings("unchecked")
    @Override
    default EntityType<LiveChicken, ChickenSnapshot> getType() {
        return EntityTypes.CHICKEN.get();
    }

}
