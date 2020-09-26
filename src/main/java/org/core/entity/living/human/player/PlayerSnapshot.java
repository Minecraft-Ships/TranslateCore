package org.core.entity.living.human.player;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

public interface PlayerSnapshot extends Player<EntitySnapshot<? extends LiveEntity>>, EntitySnapshot.NoneDestructibleSnapshot<LivePlayer> {

    @Override
    default EntityType<LivePlayer, PlayerSnapshot> getType(){
        return Player.super.getType();
    }

}
