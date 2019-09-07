package org.core.world.position.block.details;

import org.core.world.position.BlockPosition;
import org.core.world.position.Positionable;

public interface BlockSnapshot extends BlockDetails, Positionable {

    @Override
    BlockPosition getPosition();

    @Override
    BlockSnapshot createCopyOf();
}
