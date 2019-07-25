package org.core.entity.living.fish.cod;

import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.entity.living.fish.FishEntity;

public interface Cod extends FishEntity {

    @Override
    default EntityType<LiveCod, CodSnapshot> getType(){
        return EntityTypes.COD;
    }

}
