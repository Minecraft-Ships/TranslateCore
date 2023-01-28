package org.core.event.events.command;

import org.core.entity.living.human.player.LivePlayer;
import org.core.event.events.entity.EntityEvent;
import org.jetbrains.annotations.NotNull;

public interface PlayerCommandEvent extends CommandEvent, EntityEvent<LivePlayer> {

    @Override
    default @NotNull LivePlayer getSource() {
        return this.getEntity();
    }
}
