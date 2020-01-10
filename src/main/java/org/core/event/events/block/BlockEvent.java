package org.core.event.events.block;

import org.core.event.Event;
import org.core.world.position.BlockPosition;
import org.core.world.position.Positionable;

public interface BlockEvent extends Positionable, Event {

    @Override
    BlockPosition getPosition();
}
