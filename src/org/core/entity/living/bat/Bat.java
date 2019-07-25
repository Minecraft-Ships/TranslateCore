package org.core.entity.living.bat;

import org.core.entity.Entity;
import org.core.entity.EntityType;
import org.core.entity.EntityTypes;

public interface Bat extends Entity {

    boolean isAwake();
    Bat setAwake(boolean state);

    @Override
    default EntityType<LiveBat, BatSnapshot> getType(){
        return EntityTypes.BAT;
    }
}
