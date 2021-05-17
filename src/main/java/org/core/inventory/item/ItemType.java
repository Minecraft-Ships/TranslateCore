package org.core.inventory.item;

import org.core.inventory.item.stack.ItemStackSnapshot;
import org.core.utils.Identifiable;
import org.core.world.position.block.BlockType;

import java.util.Optional;

public interface ItemType extends Identifiable {

    ItemStackSnapshot getDefaultItemStack();
    Optional<BlockType> getBlockType();
}
