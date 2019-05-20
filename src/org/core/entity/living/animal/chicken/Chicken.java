package org.core.entity.living.animal.chicken;

import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.entity.living.animal.AnimalEntity;

public interface Chicken extends AnimalEntity {

    @Override
    default EntityType<Chicken, ChickenSnapshot> getType() {
        return EntityTypes.CHICKEN;
    }

}
