package org.core.world.position.block.details.blocks.sign;

import org.core.exceptions.DirectionNotSupported;
import org.core.world.direction.Direction;
import org.core.world.direction.FourFacingDirection;
import org.core.world.position.block.details.AttachableDetails;

public interface WallSign extends GeneralSign, AttachableDetails {

    @Override
    default Direction[] getFacingDirections(){
        return FourFacingDirection.getFourFacingDirections();
    }

    @Override
    default Direction[] getAttachableDirections(){
        return getFacingDirections();
    }

    @Override
    default WallSign setFacingDirection(Direction direction) throws DirectionNotSupported {
        return this.setAttachedDirection(direction.getOpposite());
    }

    @Override
    default Direction getFacingDirection() {
        return this.getAttachedDirection().getOpposite();
    }

    @Override
    WallSign setAttachedDirection(Direction direction) throws DirectionNotSupported;

}
