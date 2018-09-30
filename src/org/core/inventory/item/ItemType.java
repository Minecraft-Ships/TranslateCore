package org.core.inventory.item;

import org.core.utils.Identifable;
import org.core.world.position.block.BlockType;

import java.util.Optional;

public interface ItemType extends Identifable {

    public ItemStack getDefaultItemStack();
    public Optional<BlockType> getBlockType();
}
