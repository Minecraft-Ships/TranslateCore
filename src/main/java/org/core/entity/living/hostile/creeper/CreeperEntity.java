package org.core.entity.living.hostile.creeper;

import org.core.entity.Entity;
import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.entity.living.hostile.HostileEntity;

public interface CreeperEntity<E extends Entity<?>> extends HostileEntity<E> {

    boolean isCharged();

    CreeperEntity<E> setCharged(boolean check);

    @Override
    default EntityType<LiveCreeperEntity, CreeperEntitySnapshot> getType() {
        return EntityTypes.CREEPER.get();
    }
}
