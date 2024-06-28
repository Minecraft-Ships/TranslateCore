package org.core.world;

import org.core.vector.type.Vector3;
import org.core.world.chunk.Chunk;
import org.core.world.position.impl.sync.SyncPosition;
import org.jetbrains.annotations.NotNull;

public interface ChunkExtent extends Extent, Chunk {

    WorldExtent getWorld();

    @Override
    default @NotNull <N extends Number> SyncPosition<N> getPosition(@NotNull Vector3<N> vector) {
        return Extent.super.getPosition(vector);
    }
}
