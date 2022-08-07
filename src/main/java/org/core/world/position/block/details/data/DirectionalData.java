package org.core.world.position.block.details.data;

import org.core.exceptions.DirectionNotSupported;
import org.core.world.direction.Direction;

public interface DirectionalData {

    Direction getDirection();

    DirectionalData setDirection(Direction direction) throws DirectionNotSupported;

    Direction[] getSupportedDirections();
}
