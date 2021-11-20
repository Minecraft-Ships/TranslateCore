package org.core.collection;

import org.core.world.position.block.details.BlockDetails;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;

public class BlockSetDetails extends HashSet<BlockDetails> {

    public BlockSetDetails() {
    }

    public BlockSetDetails(@NotNull Collection<? extends BlockDetails> c) {
        super(c);
    }

    @Override
    public BlockSetDetails clone() {
        return new BlockSetDetails(this);
    }
}
