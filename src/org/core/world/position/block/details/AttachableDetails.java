package org.core.world.position.block.details;

import org.core.exceptions.DirectionNotSupported;
import org.core.world.direction.Direction;

public interface AttachableDetails extends BlockDetails {

    public Direction getAttachedDirection();
    public AttachableDetails setAttachedDirection(Direction direction) throws DirectionNotSupported;
    public Direction[] getAttachableDirections();
}
