package org.core.world.position.block.details;

import org.core.world.direction.Direction;

public interface RotateDetails {

    public Direction[] getFacingDirections();
    public Direction getFacingDirection();

    public RotateDetails setFacingDirection(Direction direction);

    public default boolean canFace(Direction direction){
        for(Direction dir : getFacingDirections()){
            if(dir.equals(direction)){
                return true;
            }
        }
        return false;
    }

}
