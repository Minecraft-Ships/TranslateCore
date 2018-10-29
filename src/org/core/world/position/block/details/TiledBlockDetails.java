package org.core.world.position.block.details;

import org.core.world.position.block.entity.TileEntity;
import org.core.world.position.block.entity.TileEntitySnapshot;

public interface TiledBlockDetails<T extends TileEntity, S extends TileEntitySnapshot<T>> extends BlockDetails {

    S getTileEntity();
    void setTileEntity(S tile);
}
