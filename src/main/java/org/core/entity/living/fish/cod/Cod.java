package org.core.entity.living.fish.cod;

import org.core.entity.Entity;
import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.entity.living.fish.FishEntity;

public interface Cod<E extends Entity<?>> extends FishEntity<E> {

    @Override
    @SuppressWarnings("unchecked")
    default EntityType<LiveCod, CodSnapshot> getType(){
        return EntityTypes.COD.get();
    }

}
