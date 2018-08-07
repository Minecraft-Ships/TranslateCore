package org.core.world.position.block;

import org.core.utils.Identifable;
import org.core.world.position.block.details.BlockDetails;

import java.util.Set;

public interface BlockType extends Identifable {

    BlockDetails getDefaultBlockDetails();

    Set<BlockType> getLike();

    default boolean isLike(BlockType type) {
        return getLike().stream().anyMatch(t -> t.equals(type));
    }

}
