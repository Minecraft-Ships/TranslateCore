package org.core.entity.living.hostile.creeper;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

public interface CreeperEntitySnapshot extends CreeperEntity<EntitySnapshot<? extends LiveEntity>>, EntitySnapshot<LiveCreeperEntity> {

    @SuppressWarnings("unchecked")
    default EntityType<LiveCreeperEntity, CreeperEntitySnapshot> getType(){
        return CreeperEntity.super.getType();
    }

}
