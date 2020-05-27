package org.core.event.events.entity;

import org.core.entity.Entity;
import org.core.entity.living.human.player.LivePlayer;
import org.core.event.events.Cancellable;
import org.core.world.direction.Direction;
import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.impl.sync.SyncPosition;

public interface EntityInteractEvent<E extends Entity> extends EntityEvent<E>, Cancellable {

    int PRIMARY_CLICK_ACTION = 0;
    int SECONDARY_CLICK_ACTION = 1;

    SyncPosition<? extends Number> getInteractPosition();

    int getClickAction();

    interface WithBlock<E extends Entity> extends EntityInteractEvent<E>{

        @Override
        SyncBlockPosition getInteractPosition();

        interface AsPlayer extends EntityInteractEvent.WithBlock<LivePlayer>{

            Direction getClickedBlockFace();

        }

    }
}
