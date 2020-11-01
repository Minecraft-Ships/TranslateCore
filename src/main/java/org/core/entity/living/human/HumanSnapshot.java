package org.core.entity.living.human;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

public interface HumanSnapshot extends Human<EntitySnapshot<? extends LiveEntity>>, EntitySnapshot<LiveHuman> {

    @Override
    default EntityType<LiveHuman, HumanSnapshot> getType(){
        return Human.super.getType();
    }

}
