package org.core.entity;

import org.core.utils.Identifable;

public interface EntityType <T extends Entity, S extends EntitySnapshot<T>> extends Identifable {

    Class<T> getEntityClass();
    Class<S> getSnapshotClass();

}
