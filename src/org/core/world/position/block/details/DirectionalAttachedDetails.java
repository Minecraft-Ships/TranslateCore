package org.core.world.position.block.details;

import org.core.exceptions.DirectionNotSupported;
import org.core.world.direction.Direction;

public interface DirectionalAttachedDetails extends RotateDetails, AttachableDetails {

    @Override
    default Direction[] getAttachableDirections(){
        return getFacingDirections();
    }

    @Override
    default DirectionalAttachedDetails setFacingDirection(Direction direction) throws DirectionNotSupported {
        return this.setAttachedDirection(direction.getOpposite());
    }

    @Override
    default Direction getFacingDirection() {
        return this.getAttachedDirection().getOpposite();
    }

    @Override
    DirectionalAttachedDetails setAttachedDirection(Direction direction) throws DirectionNotSupported;
}
