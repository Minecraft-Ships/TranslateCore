package org.core.event.events.block;

import org.core.entity.living.human.player.LivePlayer;
import org.core.event.PlatformEvent;
import org.core.event.events.Cancellable;
import org.core.event.events.entity.EntityEvent;
import org.core.world.position.block.details.BlockDetails;

public interface BlockChangeEvent extends BlockEvent, PlatformEvent {

    BlockDetails getBeforeState();
    BlockDetails getAfterState();

    interface Break extends BlockChangeEvent {

        interface ByPlayer extends Break, Cancellable, EntityEvent<LivePlayer> {

        }
    }

    interface Place extends BlockChangeEvent {

        interface ByPlayer extends Place, Cancellable, EntityEvent<LivePlayer> {

        }
    }
}
