package org.core.world.position.block.details.blocks.banner;

import org.core.world.direction.Direction;
import org.core.world.direction.FourFacingDirection;
import org.core.world.position.block.details.RotateDetails;
import org.core.world.position.block.details.TiledBlockDetails;
import org.core.world.position.block.entity.banner.BannerTileEntitySnapshot;
import org.core.world.position.block.entity.banner.LiveBannerTileEntity;

public interface GeneralBanner extends RotateDetails, TiledBlockDetails<LiveBannerTileEntity, BannerTileEntitySnapshot> {

    @Override
    default Direction[] getFacingDirections(){
        return FourFacingDirection.getFourFacingDirections();
    }

}
