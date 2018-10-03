package org.core.entity;

public interface EntitySnapshot<E extends Entity> extends Entity {

    public E getOrCreateEntity();
}
