package org.core.entity;

import java.util.Optional;

/**
 * The base class for EntitySnapshots. An EntitySnapshot is a Entity that isn't in the world that
 * you can create multiple Entities from.
 * @param <E> The live entity type of this EntitySnapshot
 */
public interface EntitySnapshot<E extends LiveEntity> extends Entity<EntitySnapshot<? extends LiveEntity>> {

    /**
     * Spawn the entity in the current condition of the snapshot
     * @return Spawns the entity
     */
    E spawnEntity();

    /**
     * Creates a new instance of this snapshot with all values
     * copied over as new instances
     * @return A new snapshot
     */
    EntitySnapshot<E> createSnapshot();

    /**
     * If the entity is based on a LiveEntity then this will be
     * returnable.
     * @return Optional of the original entity
     */
    Optional<E> getCreatedFrom();
}
