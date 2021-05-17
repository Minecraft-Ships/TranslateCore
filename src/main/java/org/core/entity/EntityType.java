package org.core.entity;

import org.core.utils.Identifiable;

/**
 * The base type of the Entity
 * @param <T> The LiveEntity class type
 * @param <S> The EntitySnapshot class type
 */
public interface EntityType <T extends LiveEntity, S extends EntitySnapshot<T>> extends Identifiable {

    /**
     * Gets the LiveEntity class from the translation layer
     * @return The LiveEntity class
     */
    Class<? extends T> getEntityClass();

    /**
     * Gets the EntitySnapshot class from the translation layer
     * @return The EntitySnapshot class
     */
    Class<? extends S> getSnapshotClass();

}
