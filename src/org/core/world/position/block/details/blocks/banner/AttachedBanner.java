package org.core.world.position.block.details.blocks.banner;

import org.core.world.direction.Direction;
import org.core.world.direction.FourFacingDirection;
import org.core.world.position.block.details.DirectionalAttachedDetails;

public interface AttachedBanner extends DirectionalAttachedDetails, GeneralBanner {

    @Override
    default Direction[] getAttachableDirections(){
        return FourFacingDirection.getFourFacingDirections();
    }
}
