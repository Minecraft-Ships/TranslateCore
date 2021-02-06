package org.core.world;

import org.core.vector.type.Vector3;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface WorldExtent extends Extent {

    String getName();
    UUID getUniqueId();
    String getPlatformUniqueId();
    Set<ChunkExtent> getChunks();
    Optional<ChunkExtent> getChunk(Vector3<Integer> vector);
    ChunkExtent loadChunk(Vector3<Integer> vector);
}
