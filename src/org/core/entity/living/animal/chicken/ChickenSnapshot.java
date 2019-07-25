package org.core.entity.living.animal.chicken;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;

public interface ChickenSnapshot extends Chicken, EntitySnapshot<LiveChicken> {

    @Override
    default EntityType<LiveChicken, ChickenSnapshot> getType(){
        return Chicken.super.getType();
    }

}
