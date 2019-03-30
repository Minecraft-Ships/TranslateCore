package org.core.world.position.block.entity.banner;

import org.core.world.position.block.entity.TileEntity;
import org.core.world.position.block.entity.banner.pattern.PatternLayers;

public interface BannerTileEntity extends TileEntity {

    PatternLayers getLayers();

    @Override
    BannerTileEntitySnapshot getSnapshot();
}
