package org.core.entity.living.fish.cod;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

public interface CodSnapshot extends Cod<EntitySnapshot<? extends LiveEntity>>, EntitySnapshot<LiveCod> {

    @SuppressWarnings("unchecked")
    @Override
    default EntityType<LiveCod, CodSnapshot> getType(){
        return Cod.super.getType();
    }
}
