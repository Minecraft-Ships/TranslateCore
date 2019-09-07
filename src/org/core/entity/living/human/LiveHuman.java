package org.core.entity.living.human;

import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

public interface LiveHuman extends Human<LiveEntity>, LiveEntity {

    @Override
    default EntityType<LiveHuman, HumanSnapshot> getType(){
        return Human.super.getType();
    }
}
