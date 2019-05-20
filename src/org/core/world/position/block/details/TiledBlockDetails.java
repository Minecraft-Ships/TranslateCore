package org.core.world.position.block.details;

import org.core.world.position.block.entity.TileEntity;
import org.core.world.position.block.entity.TileEntitySnapshot;

/**
 * <p>If the Block typically has a TileEntity attached to it, then this will be implemented as the TileEntity to use when the BlockDetails is set</p>
 * @param <T> The TileEntity class type that should be used
 * @param <S> The TileEntitySnapshot class type that should be used
 */
public interface TiledBlockDetails<T extends TileEntity, S extends TileEntitySnapshot<T>> extends BlockDetails {

    /**
     * <p>Gets the TileEntitySnapshot used on this instance of the BlockDetails</p>
     * @return The TileEntitySnapshot used on this instance of the BlockDetails.
     */
    S getTileEntity();

    /**
     * <p>Sets the TileEntity for this instance of the BlockDetails</p>
     * @param tile The TileEntitySnapshot instance to set
     */
    void setTileEntity(S tile);
}
