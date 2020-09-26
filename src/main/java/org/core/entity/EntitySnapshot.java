package org.core.entity;

import java.util.Optional;

/**
 * The base class for EntitySnapshots. An EntitySnapshot is a Entity that isn't in the world that
 * you can create multiple Entities from.
 * @param <E> The live entity type of this EntitySnapshot
 */
public interface EntitySnapshot<E extends LiveEntity> extends Entity<EntitySnapshot<? extends LiveEntity>> {

    interface NoneDestructibleSnapshot<E extends LiveEntity> extends EntitySnapshot<E>{

        /**
         * Teleports the entity from its current position into the state of the snapshot
         * @param keepInventory If the entity should keep its current inventory or apply the snapshot inventory
         * @return The teleported entity
         */
        E teleportEntity(boolean keepInventory);

        /**
         * Gets the entity to teleport {@link NoneDestructibleSnapshot#teleportEntity(boolean)}
         * @return The entity of the snapshot
         */
        default E getEntity(){
            return this.getCreatedFrom().get();
        }

    }

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
