package org.core.entity.living.animal.chicken;

import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

public interface LiveChicken extends Chicken<LiveEntity>, LiveEntity {

    @SuppressWarnings("unchecked")
    @Override
    default EntityType<LiveChicken, ChickenSnapshot> getType(){
        return Chicken.super.getType();
    }

}
