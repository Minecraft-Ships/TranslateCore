package org.core.event.events.entity;

import org.core.entity.Entity;
import org.core.event.Event;

public interface EntityEvent<E extends Entity> extends Event {

    E getEntity();
}
