package org.core.world.position.block.details.blocks;

import org.core.exceptions.DirectionNotSupported;
import org.core.world.direction.Direction;
import org.core.world.direction.FourFacingDirection;
import org.core.world.position.block.details.AttachableDetails;
import org.core.world.position.block.details.BlockDetails;
import org.core.world.position.block.details.RotateDetails;
import org.core.world.position.block.details.TiledBlockDetails;
import org.core.world.position.block.entity.sign.SignTileEntity;
import org.core.world.position.block.entity.sign.SignTileEntitySnapshot;

public interface WallSign extends BlockDetails, RotateDetails, AttachableDetails, TiledBlockDetails<SignTileEntity, SignTileEntitySnapshot> {

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
