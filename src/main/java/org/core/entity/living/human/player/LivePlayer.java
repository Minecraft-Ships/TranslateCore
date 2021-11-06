package org.core.entity.living.human.player;

import org.core.entity.EntityType;
import org.core.entity.LiveEntity;
import org.core.permission.Permission;
import org.core.source.viewer.CommandViewer;
import org.core.world.position.impl.BlockPosition;

import java.util.Optional;

public interface LivePlayer extends Player<LiveEntity>, LiveEntity, CommandViewer {

    @Deprecated
    boolean hasPermission(String permission);

    Optional<BlockPosition> getBlockLookingAt(int scanLength);

    default Optional<BlockPosition> getBlockLookingAt() {
        return this.getBlockLookingAt(7);
    }

    @SuppressWarnings("unchecked")
    default EntityType<LivePlayer, PlayerSnapshot> getType() {
        return Player.super.getType();
    }

    boolean hasPermission(Permission permission);

}
