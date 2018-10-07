package org.core.entity.living.human.player;

import org.core.entity.EntityType;
import org.core.entity.LiveEntity;
import org.core.source.viewer.CommandViewer;

public interface LivePlayer extends Player, LiveEntity, CommandViewer {

    @Override
    default EntityType<Player, PlayerSnapshot> getType(){
        return Player.super.getType();
    }

}
