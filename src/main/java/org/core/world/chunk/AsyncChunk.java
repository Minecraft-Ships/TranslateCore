package org.core.world.chunk;

import org.core.vector.type.Vector3;
import org.core.world.position.block.details.BlockDetails;
import org.jetbrains.annotations.NotNull;

public interface AsyncChunk extends Chunk {

    BlockDetails getDetails(@NotNull Vector3<Integer> vector);

}
