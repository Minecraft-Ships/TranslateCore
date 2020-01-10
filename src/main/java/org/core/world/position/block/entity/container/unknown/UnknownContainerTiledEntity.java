package org.core.world.position.block.entity.container.unknown;

import org.core.inventory.inventories.general.block.UnknownBlockAttachedInventory;
import org.core.world.position.block.entity.container.ContainerTileEntity;

public interface UnknownContainerTiledEntity extends ContainerTileEntity {

    @Override
    UnknownContainerTileEntitySnapshot getSnapshot();

    @Override
    UnknownBlockAttachedInventory getInventory();
}
