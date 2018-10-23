package org.core.event.events.entity;

import org.core.entity.Entity;
import org.core.entity.living.human.player.LivePlayer;
import org.core.event.events.Cancellable;
import org.core.world.direction.Direction;
import org.core.world.position.BlockPosition;
import org.core.world.position.Position;

public interface EntityInteractEvent<E extends Entity> extends EntityEvent<E>, Cancellable {

    Position<? extends Number> getInteractPosition();

    interface WithBlock<E extends Entity> extends EntityInteractEvent<E>{

        @Override
        BlockPosition getInteractPosition();

        interface AsPlayer extends EntityInteractEvent.WithBlock<LivePlayer>{

            Direction getClickedBlockFace();

        }

    }
}
