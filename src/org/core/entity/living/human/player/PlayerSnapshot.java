package org.core.entity.living.human.player;

import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.entity.living.human.AbstractHumanSnapshot;

public interface PlayerSnapshot extends Player, AbstractHumanSnapshot<Player> {

    @Override
    default EntityType<Player, PlayerSnapshot> getType(){
        return EntityTypes.PLAYER;
    }

}
