package org.core.entity.living.fish.cod;

import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;

public interface CodSnapshot extends Cod, EntitySnapshot<LiveCod> {

    @Override
    default EntityType<LiveCod, CodSnapshot> getType(){
        return Cod.super.getType();
    }
}
