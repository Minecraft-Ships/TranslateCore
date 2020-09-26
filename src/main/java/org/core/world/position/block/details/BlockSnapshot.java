package org.core.world.position.block.details;

import org.core.world.position.Positionable;
import org.core.world.position.impl.Position;

public interface BlockSnapshot<P extends Position<Integer>> extends BlockDetails, Positionable<P> {

    @Override
    BlockSnapshot<P> createCopyOf();
}
