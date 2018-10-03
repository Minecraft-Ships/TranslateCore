package org.core.entity.living.human;

import org.core.entity.EntityType;
import org.core.entity.EntityTypes;

public interface HumanSnapshot extends AbstractHumanSnapshot<Human> {

    @Override
    default EntityType<Human, HumanSnapshot> getType(){
        return EntityTypes.HUMAN;
    }

}
