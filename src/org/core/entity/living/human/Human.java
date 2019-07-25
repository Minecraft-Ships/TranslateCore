package org.core.entity.living.human;

import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.entity.living.Creature;

public interface Human extends AbstractHuman, Creature {

    @Override
    default EntityType<LiveHuman, HumanSnapshot> getType(){
        return EntityTypes.HUMAN;
    }
}
