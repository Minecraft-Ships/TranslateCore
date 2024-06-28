package org.core.world;

import org.core.vector.type.Vector3;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface WorldExtent extends Extent {

    String getName();

    UUID getUniqueId();

    String getPlatformUniqueId();

    @Deprecated(forRemoval = true)
    default Set<ChunkExtent> getChunks() {
        return this.getChunkExtents().collect(Collectors.toSet());
    }

    Stream<ChunkExtent> getChunkExtents();

    @NotNull Optional<ChunkExtent> getChunk(@NotNull Vector3<Integer> vector);

    @NotNull CompletableFuture<ChunkExtent> loadChunkAsynced(@NotNull Vector3<Integer> vector);

    @NotNull ChunkExtent loadChunk(@NotNull Vector3<Integer> vector);

    int getMinimumBlockHeight();

    default CompletableFuture<ChunkExtent> loadChunkAtAsynced(@NotNull Vector3<?> position) {
        return this.loadChunkAsynced(this.getAsyncPosition(position).getChunkPosition());
    }

    default ChunkExtent loadChunkAt(@NotNull Vector3<?> position) {
        return this.loadChunk(this.getAsyncPosition(position).getChunkPosition());
    }
}
