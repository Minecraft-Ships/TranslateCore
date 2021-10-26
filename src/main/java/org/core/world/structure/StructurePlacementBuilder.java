package org.core.world.structure;

import org.core.world.position.impl.BlockPosition;
import org.jetbrains.annotations.Nullable;

public class StructurePlacementBuilder {

    private BlockPosition position;

    public @Nullable BlockPosition getPosition() {
        return this.position;
    }

    public StructurePlacementBuilder setPosition(BlockPosition position) {
        this.position = position;
        return this;
    }

}
