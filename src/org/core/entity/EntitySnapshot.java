package org.core.entity;

import java.util.Optional;

public interface EntitySnapshot<E extends LiveEntity> extends Entity<EntitySnapshot<? extends LiveEntity>> {

    E spawnEntity();
    EntitySnapshot<E> createSnapshot();
    Optional<E> getCreatedFrom();
}
