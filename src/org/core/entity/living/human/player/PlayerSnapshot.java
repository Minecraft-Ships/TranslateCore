package org.core.entity.living.human.player;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;

public interface PlayerSnapshot extends Player, EntitySnapshot<LivePlayer> {

    default EntityType<LivePlayer, PlayerSnapshot> getType(){
        return Player.super.getType();
    }

}
