package org.core.world;

import org.core.vector.type.Vector3;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface WorldExtent extends Extent {

    String getName();

    UUID getUniqueId();

    String getPlatformUniqueId();

    Set<ChunkExtent> getChunks();

    Optional<ChunkExtent> getChunk(Vector3<Integer> vector);

    CompletableFuture<ChunkExtent> loadChunkAsynced(Vector3<Integer> vector);

    ChunkExtent loadChunk(Vector3<Integer> vector);

    int getMinimumBlockHeight();

    default CompletableFuture<ChunkExtent> loadChunkAtAsynced(Vector3<?> position) {
        return this.loadChunkAsynced(this.getAsyncPosition(position).getChunkPosition());
    }

    default ChunkExtent loadChunkAt(Vector3<?> position) {
        return this.loadChunk(this.getAsyncPosition(position).getChunkPosition());
    }
}
