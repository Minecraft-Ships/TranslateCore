package org.core.world.chunk;

import org.core.platform.TranslateCorePlatformDetails;
import org.core.threadsafe.ThreadSafe;
import org.core.utils.Bounds;
import org.core.vector.type.Vector3;

public interface Chunk {

    Vector3<Integer> getChunkPosition();

    boolean isLoaded();

    Vector3<Integer> getMinimumBlock();

    Vector3<Integer> getMaximumBlock();

    default Bounds<Integer> getBounds() {
        return new Bounds<>(this.getMinimumBlock(), this.getMaximumBlock());
    }

    @ThreadSafe(impl = TranslateCorePlatformDetails.BUKKIT_ID)
    AsyncChunk createAsync();

}
