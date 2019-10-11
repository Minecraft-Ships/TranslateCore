package org.core.entity.projectile.item.snowball;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

public interface SnowballEntitySnapshot extends SnowballEntity<EntitySnapshot<? extends LiveEntity>>, EntitySnapshot<LiveSnowballEntity> {

    @SuppressWarnings("unchecked")
    @Override
    default EntityType<LiveSnowballEntity, SnowballEntitySnapshot> getType(){
        return SnowballEntity.super.getType();
    }

}
