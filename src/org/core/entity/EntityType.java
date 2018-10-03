package org.core.entity;

import org.core.utils.Identifable;

public interface EntityType <T extends Entity, S extends EntitySnapshot<T>> extends Identifable {

    public Class<T> getEntityClass();
    public Class<S> getSnapshotClass();

}
