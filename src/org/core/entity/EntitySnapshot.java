package org.core.entity;

public interface EntitySnapshot<E extends LiveEntity> extends Entity {

    E spawnEntity();
    EntitySnapshot<E> createSnapshot();
}
