package org.core.entity.living.fish.cod;

import org.core.entity.EntityType;
import org.core.entity.LiveEntity;

public interface LiveCod extends Cod<LiveEntity>, LiveEntity {

    @Override
    default EntityType<LiveCod, CodSnapshot> getType(){
        return Cod.super.getType();
    }
}
