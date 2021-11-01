package org.core.collection;

import org.core.world.position.block.details.BlockSnapshot;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;

public class BlockSetSnapshot extends HashSet<BlockSnapshot<?>> {

    public BlockSetSnapshot() {
    }

    public BlockSetSnapshot(@NotNull Collection<? extends BlockSnapshot<?>> c) {
        super(c);
    }

    @Override
    public BlockSetSnapshot clone() {
        return new BlockSetSnapshot(this);
    }
}
