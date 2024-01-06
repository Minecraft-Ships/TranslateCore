package org.core.entity;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.core.adventureText.AText;
import org.core.adventureText.adventure.AdventureText;
import org.core.vector.type.Vector3;
import org.core.world.direction.Direction;
import org.core.world.direction.EightFacingDirection;
import org.core.world.direction.FourFacingDirection;
import org.core.world.direction.SixteenFacingDirection;
import org.core.world.position.Positionable;
import org.core.world.position.block.BlockTypes;
import org.core.world.position.impl.Position;
import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.impl.sync.SyncExactPosition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

/**
 * Class to represent all Entity types within the Minecraft game
 *
 * @param <T> Options are either LiveEntity or EntitySnapshot
 */
public interface Entity<T extends Entity<?>> extends Positionable<SyncExactPosition> {

    /**
     * Adds passengers to the current entity.
     * The passengers must be of the same type
     * (as in LiveEntity or EntitySnapshot)
     * of this entity.
     *
     * @param entities Collection of entities to add
     * @return itself for chaining
     */
    Entity<T> addPassengers(Collection<? extends T> entities);

    /**
     * Adds passengers to the current entity.
     * The passengers must be of the same type
     * (as in LiveEntity or EntitySnapshot)
     * of this entity.
     *
     * @param entities Collection of entities to add
     * @return itself for chaining
     */
    @SuppressWarnings("unchecked")
    default Entity<T> addPassengers(T... entities) {
        return this.addPassengers(Arrays.asList(entities));
    }

    /**
     * Removes all passengers from the entity
     *
     * @return itself for chaining
     */
    default Entity<T> clearPassengers() {
        return this.removePassengers(this.getPassengers());
    }

    /**
     * Create a snapshot of this instance of the entity
     *
     * @return The created snapshot
     */
    EntitySnapshot<? extends LiveEntity> createSnapshot();

    /**
     * Gets the block that the entity is attached to, this could be
     * the block that the entity is standing on
     *
     * @return The attached block if present
     */
    default Optional<SyncBlockPosition> getAttachedTo() {
        SyncBlockPosition block = this.getPosition().getRelative(Vector3.valueOf(0, -0.1, 0)).toBlockPosition();
        if (block.getBlockType().equals(BlockTypes.AIR)) {
            return Optional.empty();
        }
        return Optional.of(block);
    }

    /**
     * Gets the custom name of the entity, even
     * if the custom name is not visible
     *
     * @return Optional of the custom name, if the custom name has not been set it will return a Optional.empty
     */
    @Deprecated(forRemoval = true)
    default Optional<AText> getCustomName() {
        return this.getCustomNameComponent().map(AdventureText::new);
    }

    /**
     * Sets the custom name of the entity.
     * For players this is the display name.
     *
     * @param text the name to be
     * @return itself for chaining
     */
    @Deprecated(forRemoval = true)
    default Entity<T> setCustomName(@Nullable AText text) {
        return setCustomName((ComponentLike) text);
    }

    Entity<T> setCustomName(@Nullable Component component);

    default Entity<T> setCustomName(@Nullable ComponentLike like) {
        if (like == null) {
            return this.setCustomName((Component) null);
        }
        return this.setCustomName(like.asComponent());
    }

    Optional<Component> getCustomNameComponent();

    /**
     * Gets the position the entity is facing in as a Direction
     *
     * @return A direction of the entities facing direction
     */
    default Direction getFacingDirection() {
        double yaw = this.getYaw();
        if (yaw < 0) {
            yaw = yaw + 360;
        }
        yaw = yaw % 360;
        int i = (int) ((yaw + 8) / 22.5);
        return switch (i) {
            case 1 -> SixteenFacingDirection.WEST_NORTH_WEST;
            case 2 -> EightFacingDirection.NORTH_WEST;
            case 3 -> SixteenFacingDirection.NORTH_NORTH_WEST;
            case 4 -> FourFacingDirection.NORTH;
            case 5 -> SixteenFacingDirection.NORTH_NORTH_EAST;
            case 6 -> EightFacingDirection.NORTH_EAST;
            case 7 -> SixteenFacingDirection.EAST_NORTH_EAST;
            case 8 -> FourFacingDirection.EAST;
            case 9 -> SixteenFacingDirection.EAST_SOUTH_EAST;
            case 10 -> EightFacingDirection.SOUTH_EAST;
            case 11 -> SixteenFacingDirection.SOUTH_SOUTH_EAST;
            case 12 -> FourFacingDirection.SOUTH;
            case 13 -> SixteenFacingDirection.SOUTH_SOUTH_WEST;
            case 14 -> EightFacingDirection.SOUTH_WEST;
            case 15 -> SixteenFacingDirection.WEST_SOUTH_WEST;
            default -> FourFacingDirection.WEST;
        };
    }

    /**
     * Gets the passengers of the entity.
     * The passengers must be of the same type
     * (as in LiveEntity or EntitySnapshot)
     * of the entity, if a snapshot is created of
     * a live entity then the passengers will be
     * stored with the created snapshot. And restored
     * as different instances when the snapshot is restored
     *
     * @return A collection of all passengers
     */
    Collection<T> getPassengers();

    /**
     * Gets the current pitch of the entity
     *
     * @return the current pitch of the entity
     */
    double getPitch();

    /**
     * Sets the pitch of the entities rotation
     *
     * @param value The pitch to be
     * @return Itself for chaining
     */
    Entity<T> setPitch(double value);

    /**
     * Gets the position the entity is.
     *
     * @return The Exact Position the entity is
     */
    @Override
    SyncExactPosition getPosition();

    /**
     * Gets the roll of the entity,
     * note that as Bukkit does not support
     * roll, then the result will be 0
     *
     * @return The roll of the entity
     */
    double getRoll();

    /**
     * Sets the Roll of the entities rotation.
     * Note that bukkit does not support roll,
     * therefore there will be no result in Bukkit
     *
     * @param value the roll to be
     * @return Itself for chaining
     */
    Entity<T> setRoll(double value);

    /**
     * Gets the type of the entity
     *
     * @param <E> Itself as a LiveEntity
     * @return The Entity Type
     */
    <E extends LiveEntity> EntityType<E, ? extends EntitySnapshot<E>> getType();

    /**
     * Gets the current velocity of the entity
     *
     * @return The current velocity
     */
    Vector3<Double> getVelocity();

    /**
     * Sets the velocity of the entity
     *
     * @param velocity the velocity to be
     * @return itself for chaining
     */
    Entity<T> setVelocity(Vector3<Double> velocity);

    /**
     * Gets the yaw of the current entity
     *
     * @return the current yaw of the entity
     */
    double getYaw();

    /**
     * Sets the Yaw of the entities rotation
     *
     * @param value The yaw to be
     * @return Itself for chaining
     */
    Entity<T> setYaw(double value);

    /**
     * Checks if the entity has gravity
     *
     * @return if the entity has gravity
     */
    boolean hasGravity();

    /**
     * Checks if this entity has any passengers
     *
     * @return if this has passengers
     */
    default boolean hasPassengers() {
        return !this.getPassengers().isEmpty();
    }

    /**
     * Checks if the custom name should be visible
     *
     * @return if the custom name is visible
     */
    boolean isCustomNameVisible();

    /**
     * Sets if the custom name should be visible
     *
     * @param visible if the name should be visible
     * @return itself for chaining
     */
    Entity<T> setCustomNameVisible(boolean visible);

    /**
     * Checks if the entity is on ground
     *
     * @return If the entity is on the ground
     */
    boolean isOnGround();

    boolean isRemoved();

    /**
     * Removes passengers to the current entity.
     * The passengers must be of the same type
     * (as in LiveEntity or EntitySnapshot)
     * of this entity.
     *
     * @param entities Collection of entities to remove
     * @return itself for chaining
     */
    Entity<T> removePassengers(Collection<T> entities);

    /**
     * Removes passengers to the current entity.
     * The passengers must be of the same type
     * (as in LiveEntity or EntitySnapshot)
     * of this entity.
     *
     * @param entities Collection of entities to remove
     * @return itself for chaining
     */
    @SuppressWarnings("unchecked")
    default Entity<T> removePassengers(T... entities) {
        return this.removePassengers(Arrays.asList(entities));
    }

    /**
     * Sets if the entity has gravity or not
     *
     * @param check If the entity should have gravity
     * @return itself for chaining
     */
    Entity<T> setGravity(boolean check);

    /**
     * Sets the position for the entity to be in.
     * <p>
     * Note that platforms that hold more then position information
     * in the Position class will be applied to the entity too. Such
     * as, Bukkits Location holds rotation data, therefore this should
     * be set first and then the rotation data.
     *
     * @param position The position for the entity to be in
     * @return was successful
     */
    boolean setPosition(@NotNull Position<? extends Number> position);

    /**
     * Sets the position of the entity without
     * the need of a Position, this maintains
     * the world that the entity is in
     *
     * @param vector the new position
     * @return was successful
     */
    default boolean setPosition(@NotNull Vector3<? extends Number> vector) {
        return this.setPosition(vector.getRawX().doubleValue(), vector.getRawY().doubleValue(),
                                vector.getRawZ().doubleValue());
    }

    default boolean setPosition(@NotNull Positionable<? extends Position<? extends Number>> positionable) {
        return this.setPosition(positionable.getPosition());
    }

    /**
     * Sets the position of the entity without
     * the need of a Position, this maintains
     * the world that the entity is in
     *
     * @param x The X position of the world
     * @param y The Y position of the world
     * @param z The Z position of the world
     * @return info about the teleport
     */
    default boolean setPosition(double x, double y, double z) {
        return this.setPosition(this.getPosition().getWorld().getPosition(x, y, z));
    }

    /**
     * Sets the velocity of the entity without the need
     * of a Vector
     *
     * @param x the X speed
     * @param y the Y speed
     * @param z the Z speed
     * @return itself for chaining
     */
    default Entity<T> setVelocity(double x, double y, double z) {
        return this.setVelocity(Vector3.valueOf(x, y, z));
    }

}
