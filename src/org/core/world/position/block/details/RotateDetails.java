package org.core.world.position.block.details;

import org.core.exceptions.DirectionNotSupported;
import org.core.world.direction.Direction;

/**
 * <p>If a BlockDetail can be rotated, this will be implemented. This is different to Attached as if the Attached block breaks, this block will not be affected</p>
 */
public interface RotateDetails extends BlockDetails {

    /**
     * <p>Gets the directions that the BlockDetails can face</p>
     * @return The directions that the BlockDetails can face.
     */
    Direction[] getFacingDirections();

    /**
     * <p>Gets the current direction that the BlockDetails is facing</p>
     * @return The current direction
     */
    Direction getFacingDirection();

    /**
     * <p>Sets the facing direction of the current BlockDetails</p>
     * @param direction The direction to which you wish the BlockDetail to face
     * @return this instance, for chaining
     * @throws DirectionNotSupported If the direction supplied is not allowed then this will be thrown
     */
    RotateDetails setFacingDirection(Direction direction) throws DirectionNotSupported;

    /**
     * <p>Checks if the BlockDetails can rotate to the supplied direction</p>
     * @param direction The direction to set
     * @return True if it can, False if not.
     */
    default boolean canFace(Direction direction){
        for(Direction dir : getFacingDirections()){
            if(dir.equals(direction)){
                return true;
            }
        }
        return false;
    }

}
