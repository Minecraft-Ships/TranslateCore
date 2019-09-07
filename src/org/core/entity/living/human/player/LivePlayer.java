package org.core.entity.living.human.player;

import org.core.entity.EntityType;
import org.core.entity.LiveEntity;
import org.core.source.viewer.CommandViewer;

@SuppressWarnings("unchecked")
public interface LivePlayer extends Player<LiveEntity>, LiveEntity, CommandViewer {

    boolean hasPermission(String permission);

    default EntityType<LivePlayer, PlayerSnapshot> getType(){
        return Player.super.getType();
    }

}
