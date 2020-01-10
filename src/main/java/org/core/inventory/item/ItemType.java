package org.core.inventory.item;

import org.core.inventory.item.stack.ItemStackSnapshot;
import org.core.utils.Identifable;
import org.core.world.position.block.BlockType;

import java.util.Optional;

public interface ItemType extends Identifable {

    ItemStackSnapshot getDefaultItemStack();
    Optional<BlockType> getBlockType();
}
