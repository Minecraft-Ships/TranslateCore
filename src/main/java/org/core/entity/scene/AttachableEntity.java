package org.core.entity.scene;

import org.core.entity.Entity;
import org.core.exceptions.DirectionNotSupported;
import org.core.world.direction.Direction;

public interface AttachableEntity<E extends Entity<?>> extends Entity<E> {

    Direction[] getDirections();

    Direction getDirection();

    AttachableEntity<E> setDirection(Direction direction) throws DirectionNotSupported;
}
