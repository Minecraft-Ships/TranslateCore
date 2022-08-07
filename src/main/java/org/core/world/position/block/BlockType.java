package org.core.world.position.block;

import org.core.inventory.item.ItemType;
import org.core.utils.Identifiable;
import org.core.world.position.block.details.BlockDetails;
import org.core.world.position.block.grouptype.BlockGroup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * <p>Very basic info of a block</p>
 */
public interface BlockType extends Identifiable {

    /**
     * <p>Gets the default BlockDetails from the BlockType</p>
     *
     * @return BlockDetails containing the default block details
     */
    BlockDetails getDefaultBlockDetails();

    Set<BlockGroup> getGroups();

    /**
     * <p>If the current has an ItemType variant, this will return it</p>
     *
     * @return The ItemType variant of the current BlockType
     */
    Optional<ItemType> getItemType();

    /**
     * <p>Checks if the current BlockType is like the target block type</p>
     *
     * @param type a block type to check if it like the current
     * @return returns true if the type is found in the like list, false if not
     */
    default boolean isLike(BlockType type) {
        return this.getGroups().stream().anyMatch(t -> Arrays.asList(t.getGrouped()).contains(type));
    }

    /**
     * <p>Gets all block types that are like the current. E.G if this was White_Wool then all Wool types would be
     * like it</p>
     *
     * @return All blocks types that are like the current block type.
     */
    default Set<BlockType> getLike() {
        Set<BlockType> set = new HashSet<>();
        this.getGroups().forEach(g -> {
            for (BlockType type : g.getGrouped()) {
                if (set.stream().noneMatch(bt -> bt.equals(type))) {
                    set.add(type);
                }
            }
        });
        return set;
    }

}
