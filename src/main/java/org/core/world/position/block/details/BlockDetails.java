package org.core.world.position.block.details;

import org.core.world.position.block.BlockType;
import org.core.world.position.block.details.data.DirectionalData;
import org.core.world.position.block.details.data.keyed.KeyedData;
import org.core.world.position.impl.BlockPosition;
import org.core.world.position.impl.async.ASyncBlockPosition;
import org.core.world.position.impl.sync.SyncBlockPosition;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * <p>Contains all information of a block that has not been placed</p>
 */
public interface BlockDetails {

    /**
     * Gets the BlockType variant this BlockDetails is
     *
     * @return The connected BlockType variant
     */
    BlockType getType();

    @Deprecated
    <T extends BlockPosition> BlockSnapshot<T> createSnapshot(T position);

    BlockSnapshot.AsyncBlockSnapshot createSnapshot(ASyncBlockPosition position);

    BlockSnapshot.SyncBlockSnapshot createSnapshot(SyncBlockPosition position);

    Optional<DirectionalData> getDirectionalData();

    /**
     * Creates a copy of the BlockDetails
     *
     * @return The copy of the BlockDetails
     */
    BlockDetails createCopyOf();

    <T> Optional<T> get(Class<? extends KeyedData<T>> data);

    default <T, C extends Collection<T>> Collection<T> getAll(Class<? extends KeyedData<C>> data) {
        return this.get(data).map(t -> (Collection<T>) t).orElseGet(Collections::emptySet);
    }

    <T> BlockDetails set(Class<? extends KeyedData<T>> data, T value);

    default <T> Optional<T> getUnspecified(Class<? extends KeyedData<?>> dataClass) {
        return this.get((Class<? extends KeyedData<T>>) dataClass);
    }
}
