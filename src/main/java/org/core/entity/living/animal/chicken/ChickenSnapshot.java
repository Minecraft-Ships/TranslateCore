package org.core.entity.living.animal.chicken;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

public interface ChickenSnapshot extends Chicken<EntitySnapshot<? extends LiveEntity>>, EntitySnapshot<LiveChicken> {

    @SuppressWarnings("unchecked")
    @Override
    default EntityType<LiveChicken, ChickenSnapshot> getType(){
        return Chicken.super.getType();
    }

}
