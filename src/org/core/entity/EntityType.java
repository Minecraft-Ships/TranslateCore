package org.core.entity;

import org.core.utils.Identifable;

public interface EntityType <T extends LiveEntity, S extends EntitySnapshot<T>> extends Identifable {

    Class<? extends T> getEntityClass();
    Class<? extends S> getSnapshotClass();

}
