package org.core.world.position.block.details;

import org.core.exceptions.DirectionNotSupported;
import org.core.world.direction.Direction;

/**
 * <p>Used for if a BlockDetails can attach to another block. This is typically used for if the block this is attached to breaks, this block will aso break</p>
 */
public interface AttachableDetails extends BlockDetails {

    /**
     * <p>Gets the attached direction</p>
     * @return The attached direction
     */
    Direction getAttachedDirection();

    /**
     * <p>Sets the attached direction of the BlockDetails</p>
     * @param direction The direction that you wish to set the BlockDetails as
     * @return A copy of the current AttachableDetails
     * @throws DirectionNotSupported If the BlockDetails can not be attached in the direction supplied then this will be thrown
     */
    AttachableDetails setAttachedDirection(Direction direction) throws DirectionNotSupported;

    /**
     * <p>Gets all the directions the block can be attached to</p>
     * @return
     */
    Direction[] getAttachableDirections();
}
