package org.core.world.position.block.details;

import org.core.exceptions.DirectionNotSupported;
import org.core.world.direction.Direction;

public interface RotateDetails extends BlockDetails {

    public Direction[] getFacingDirections();
    public Direction getFacingDirection();

    public RotateDetails setFacingDirection(Direction direction) throws DirectionNotSupported;

    public default boolean canFace(Direction direction){
        for(Direction dir : getFacingDirections()){
            if(dir.equals(direction)){
                return true;
            }
        }
        return false;
    }

}
