package org.core.world.position.block.details;

import org.core.world.position.block.BlockType;
import org.core.world.position.block.details.data.DirectionalData;
import org.core.world.position.block.details.data.keyed.KeyedData;
import org.core.world.position.impl.Position;

import java.util.Optional;

/**
 * <p>Contains all information of a block that has not been placed</p>
 */
public interface BlockDetails {

    /**
     * Gets the BlockType variant this BlockDetails is
     * @return The connected BlockType variant
     */
    BlockType getType();

    <T extends Position<Integer>> BlockSnapshot<T> createSnapshot(T position);

    Optional<DirectionalData> getDirectionalData();

    /**
     * Creates a copy of the BlockDetails
     * @return The copy of the BlockDetails
     */
    BlockDetails createCopyOf();

    <T extends Object> Optional<T> get(Class<? extends KeyedData<T>> data);

    <T extends Object> BlockDetails set(Class<? extends KeyedData<T>> data, T value);

    @SuppressWarnings("unchecked")
    default <T extends Object> Optional<T> getUnspecified(Class<? extends KeyedData<? extends Object>> dataClass){
        return get((Class<? extends KeyedData<T>>)dataClass);
    }
}
