package org.core.world.position.block.details;

import org.core.world.position.block.entity.TileEntity;
import org.core.world.position.block.entity.TileEntitySnapshot;

public interface UsesTileEntity <T extends TileEntity, S extends TileEntitySnapshot<T>> extends BlockDetails {

    public S getTileEntity();
}
