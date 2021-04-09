package org.core.event.events.entity;

import org.core.entity.living.human.player.LivePlayer;

public interface EntityCommandEvent extends EntityEvent<LivePlayer> {

    String[] getCommand();
}
