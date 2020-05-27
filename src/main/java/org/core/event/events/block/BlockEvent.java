package org.core.event.events.block;

import org.core.event.Event;
import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.Positionable;

public interface BlockEvent extends Positionable, Event {

    @Override
    SyncBlockPosition getPosition();
}
