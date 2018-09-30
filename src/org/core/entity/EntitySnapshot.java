package org.core.entity;

public interface EntitySnapshot<E extends Entity, T extends EntityType<E>> {

    public T getType();
    public E getOrCreateEntity();
}
