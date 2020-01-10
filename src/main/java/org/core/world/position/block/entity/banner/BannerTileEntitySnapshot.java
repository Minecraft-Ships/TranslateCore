package org.core.world.position.block.entity.banner;

import org.core.world.position.block.entity.TileEntitySnapshot;
import org.core.world.position.block.entity.banner.pattern.PatternLayersSnapshot;

public interface BannerTileEntitySnapshot extends BannerTileEntity, TileEntitySnapshot<LiveBannerTileEntity> {

    @Override
    PatternLayersSnapshot getLayers();

    @Override
    default Class<LiveBannerTileEntity> getDeclaredClass(){
        return LiveBannerTileEntity.class;
    }
}
