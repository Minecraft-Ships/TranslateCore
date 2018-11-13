package org.core.world.position.block.details.blocks.sign;

import org.core.world.direction.Direction;
import org.core.world.direction.SixteenFacingDirection;

public interface StandingSign extends GeneralSign {

    @Override
    default Direction[] getFacingDirections(){
        return SixteenFacingDirection.getSixteenFacingDirections();
    }

}
