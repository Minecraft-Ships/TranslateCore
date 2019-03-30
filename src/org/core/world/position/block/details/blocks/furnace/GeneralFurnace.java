package org.core.world.position.block.details.blocks.furnace;

import org.core.world.direction.Direction;
import org.core.world.direction.FourFacingDirection;
import org.core.world.position.block.details.LightingDetails;
import org.core.world.position.block.details.RotateDetails;
import org.core.world.position.block.details.TiledBlockDetails;
import org.core.world.position.block.entity.container.furnace.FurnaceTileEntity;
import org.core.world.position.block.entity.container.furnace.FurnaceTileEntitySnapshot;

public interface GeneralFurnace extends RotateDetails, LightingDetails, TiledBlockDetails<FurnaceTileEntity, FurnaceTileEntitySnapshot> {

    @Override
    default Direction[] getFacingDirections(){
        return FourFacingDirection.getFourFacingDirections();
    }
}
