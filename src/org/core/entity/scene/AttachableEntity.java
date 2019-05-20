package org.core.entity.scene;

import org.core.entity.Entity;
import org.core.exceptions.DirectionNotSupported;
import org.core.world.direction.Direction;

public interface AttachableEntity extends Entity {

    Direction[] getDirections();
    Direction getDirection();
    AttachableEntity setDirection(Direction direction) throws DirectionNotSupported;
}
