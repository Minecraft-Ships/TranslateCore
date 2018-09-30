package org.core.world.position.block.entity.container;

import org.core.inventory.inventories.utils.BlockAttachedInventory;
import org.core.world.position.block.entity.TileEntitySnapshot;

import java.util.Optional;

public interface ContainerTileEntitySnapshot <T extends ContainerTileEntity> extends TileEntitySnapshot<T> {

    public Optional<BlockAttachedInventory> getInventory();
}
