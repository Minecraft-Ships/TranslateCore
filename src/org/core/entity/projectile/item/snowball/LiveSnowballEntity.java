package org.core.entity.projectile.item.snowball;

import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

public interface LiveSnowballEntity extends SnowballEntity, LiveEntity {

    @Override
    default EntityType<LiveSnowballEntity, SnowballEntitySnapshot> getType(){
        return SnowballEntity.super.getType();
    }
}
