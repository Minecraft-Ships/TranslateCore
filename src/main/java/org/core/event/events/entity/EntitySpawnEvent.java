package org.core.event.events.entity;

import org.core.entity.LiveEntity;
import org.core.event.events.Cancellable;
import org.core.world.position.ExactPosition;
import org.core.world.position.Positionable;

public interface EntitySpawnEvent extends EntityEvent<LiveEntity>, Cancellable, Positionable {

    @Override
    ExactPosition getPosition();
}
