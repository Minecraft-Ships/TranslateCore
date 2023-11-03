package org.core.event.events.entity;

import org.core.entity.LiveEntity;
import org.core.entity.living.human.player.LivePlayer;
import org.core.event.events.Cancellable;
import org.core.vector.type.Vector3;
import org.core.world.position.impl.sync.SyncExactPosition;
import org.jetbrains.annotations.NotNull;

public interface EntityMoveEvent<E extends LiveEntity> extends EntityEvent<E>, Cancellable {

    @NotNull SyncExactPosition getBeforePosition();

    @NotNull SyncExactPosition getAfterPosition();

    interface AsPlayer extends EntityMoveEvent<LivePlayer> {

        enum MoveReason {
            NATURAL,
            TELEPORT
        }

        @NotNull MoveReason getReason();
    }
}
