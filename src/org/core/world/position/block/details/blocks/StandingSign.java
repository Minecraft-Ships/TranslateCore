package org.core.world.position.block.details.blocks;

import org.core.world.direction.Direction;
import org.core.world.direction.SixteenFacingDirection;
import org.core.world.position.block.details.RotateDetails;
import org.core.world.position.block.details.TiledBlockDetails;
import org.core.world.position.block.entity.sign.SignTileEntity;
import org.core.world.position.block.entity.sign.SignTileEntitySnapshot;

public interface StandingSign extends RotateDetails, TiledBlockDetails<SignTileEntity, SignTileEntitySnapshot> {

    @Override
    public default Direction[] getFacingDirections(){
        return SixteenFacingDirection.getSixteenFacingDirections();
    }

}
