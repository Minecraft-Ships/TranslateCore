package org.core.world.position.block;

import org.core.inventory.item.ItemType;
import org.core.utils.Identifable;
import org.core.world.position.block.details.BlockDetails;

import java.util.Optional;
import java.util.Set;

public interface BlockType extends Identifable {

    BlockDetails getDefaultBlockDetails();

    Set<BlockType> getLike();

    Optional<ItemType> getItemType();

    default boolean isLike(BlockType type) {
        return getLike().stream().anyMatch(t -> t.equals(type));
    }

}
