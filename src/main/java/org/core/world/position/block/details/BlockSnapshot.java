package org.core.world.position.block.details;

import org.core.world.position.Positionable;
import org.core.world.position.impl.BlockPosition;

public interface BlockSnapshot<P extends BlockPosition> extends BlockDetails, Positionable<P> {

    @Override
    BlockSnapshot<P> createCopyOf();
}
