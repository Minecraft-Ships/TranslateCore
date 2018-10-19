package org.core.event.events.entity;

import org.core.entity.Entity;

public interface EntityEvent<E extends Entity> {

    E getEntity();
}
