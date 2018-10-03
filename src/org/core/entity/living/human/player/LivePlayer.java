package org.core.entity.living.human.player;

import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

public interface LivePlayer extends Player, LiveEntity {

    @Override
    default EntityType<Player, PlayerSnapshot> getType(){
        return Player.super.getType();
    }
}
