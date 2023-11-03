package org.core.event.events.entity;

import org.core.entity.LiveEntity;
import org.core.event.events.Cancellable;

public interface EntityDeathEvent<E extends LiveEntity> extends EntityEvent<E>, Cancellable {


}
