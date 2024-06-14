package org.core.world.position.block;

import org.core.inventory.item.ItemType;
import org.core.utils.Identifiable;
import org.core.world.position.block.details.BlockDetails;
import org.core.world.position.block.grouptype.BlockGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Deprecated(forRemoval = true)
    default Set<BlockGroup> getGroups() {
        return this.getBlockGroups().collect(Collectors.toSet());
    }

    Stream<BlockGroup> getBlockGroups();

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
    default boolean isLike(@NotNull BlockType type) {
        return this.getAlike().anyMatch(t -> t.equals(type));
    }

    /**
     * <p>Gets all block types that are like the current. E.G if this was White_Wool then all Wool types would be
     * like it</p>
     *
     * @return All blocks types that are like the current block type.
     */
    @Deprecated(forRemoval = true)
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

    default Stream<BlockType> getAlike() {
        return this.getGroups().stream().flatMap(blockGroup -> Stream.of(blockGroup.getGrouped())).distinct();
    }

}
