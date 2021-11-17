package org.core.collection;

import org.core.world.position.block.details.BlockSnapshot;
import org.core.world.position.impl.BlockPosition;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;

public class BlockSetSnapshot extends HashSet<BlockSnapshot<? extends BlockPosition>> {

    public BlockSetSnapshot() {
    }

    public BlockSetSnapshot(@NotNull Collection<? extends BlockSnapshot<? extends BlockPosition>> c) {
        super(c);
    }

    @Override
    public BlockSetSnapshot clone() {
        return new BlockSetSnapshot(this);
    }
}
