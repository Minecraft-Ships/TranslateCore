package org.core.event.events.entity;

import org.core.entity.LiveEntity;
import org.core.event.events.Cancellable;
import org.core.world.position.impl.sync.SyncExactPosition;
import org.core.world.position.Positionable;

public interface EntitySpawnEvent extends EntityEvent<LiveEntity>, Cancellable, Positionable {

    @Override
    SyncExactPosition getPosition();
}
