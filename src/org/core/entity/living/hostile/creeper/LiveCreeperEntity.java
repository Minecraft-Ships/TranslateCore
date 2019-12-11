package org.core.entity.living.hostile.creeper;

import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

public interface LiveCreeperEntity extends CreeperEntity<LiveEntity>, LiveEntity {

    @Override
    default EntityType<LiveCreeperEntity, CreeperEntitySnapshot> getType() {
        return CreeperEntity.super.getType();
    }
}
