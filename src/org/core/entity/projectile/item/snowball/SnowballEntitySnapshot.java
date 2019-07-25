package org.core.entity.projectile.item.snowball;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;

public interface SnowballEntitySnapshot extends SnowballEntity, EntitySnapshot<LiveSnowballEntity> {

    @Override
    default EntityType<LiveSnowballEntity, SnowballEntitySnapshot> getType(){
        return SnowballEntity.super.getType();
    }

}
