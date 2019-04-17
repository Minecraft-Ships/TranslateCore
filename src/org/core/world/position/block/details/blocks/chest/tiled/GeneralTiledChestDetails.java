package org.core.world.position.block.details.blocks.chest.tiled;

import org.core.world.position.block.details.TiledBlockDetails;
import org.core.world.position.block.details.blocks.chest.GeneralChestDetails;
import org.core.world.position.block.entity.container.chest.ChestTileEntitySnapshot;
import org.core.world.position.block.entity.container.chest.LiveChestTileEntity;

public interface GeneralTiledChestDetails extends GeneralChestDetails, TiledBlockDetails<LiveChestTileEntity, ChestTileEntitySnapshot> {
}
