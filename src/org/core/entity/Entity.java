package org.core.entity;

import org.core.text.Text;
import org.core.vector.Vector3;
import org.core.vector.types.Vector3Double;
import org.core.world.direction.Direction;
import org.core.world.direction.EightFacingDirection;
import org.core.world.direction.FourFacingDirection;
import org.core.world.direction.SixteenFacingDirection;
import org.core.world.position.BlockPosition;
import org.core.world.position.ExactPosition;
import org.core.world.position.Position;
import org.core.world.position.Positionable;
import org.core.world.position.block.BlockTypes;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public interface Entity<T extends Entity> extends Positionable {

    @Override
    ExactPosition getPosition();

    <E extends LiveEntity> EntityType<E, ? extends EntitySnapshot<E>> getType();
    EntitySnapshot<? extends LiveEntity> createSnapshot();

    T setPitch(double value);
    T setYaw(double value);
    T setRoll(double value);
    T setPosition(Position<? extends Number> position);
    T setGravity(boolean check);
    T setVelocity(Vector3Double velocity);
    T setCustomName(Text text);
    T setCustomNameVisible(boolean visible);

    double getPitch();
    double getYaw();
    double getRoll();
    boolean hasGravity();
    Vector3Double getVelocity();
    Text getCustomName();
    boolean isCustomNameVisible();

    Collection<T> getPassengers();
    T addPassengers(Collection<T> entities);
    T removePassengers(Collection<T> entities);

    default T setVelocity(double x, double y, double z){
        return setVelocity(new Vector3Double(x, y, z));
    }

    default boolean hasPassengers(){
        return !getPassengers().isEmpty();
    }

    default T addPassengers(T... entities) {
        return addPassengers(Arrays.asList(entities));
    }

    default T removePassengers(T... entities){
        return removePassengers(Arrays.asList(entities));
    }

    default T clearPassengers(){
        return removePassengers(getPassengers());
    }

    default T setPosition(double x, double y, double z){
        return setPosition(getPosition().getWorld().getPosition(x, y, z));
    }

    default Entity setPosition(Vector3<? extends Number> vector){
        return setPosition(vector.getRawX().doubleValue(), vector.getRawY().doubleValue(), vector.getRawZ().doubleValue());
    }

    default Direction getFacingDirection(){
        double yaw = getYaw();
        if(yaw < 0){
            yaw = yaw + 360;
        }
        yaw = yaw % 360;
        int i = (int)((yaw + 8) / 22.5);
        switch (i){
            case 1: return SixteenFacingDirection.WEST_NORTH_WEST;
            case 2: return EightFacingDirection.NORTH_WEST;
            case 3: return SixteenFacingDirection.NORTH_NORTH_WEST;
            case 4: return FourFacingDirection.NORTH;
            case 5: return SixteenFacingDirection.NORTH_NORTH_EAST;
            case 6: return EightFacingDirection.NORTH_EAST;
            case 7: return SixteenFacingDirection.EAST_NORTH_EAST;
            case 8: return FourFacingDirection.EAST;
            case 9: return SixteenFacingDirection.EAST_SOUTH_EAST;
            case 10: return EightFacingDirection.SOUTH_EAST;
            case 11: return SixteenFacingDirection.SOUTH_SOUTH_EAST;
            case 12: return FourFacingDirection.SOUTH;
            case 13: return SixteenFacingDirection.SOUTH_SOUTH_WEST;
            case 14: return EightFacingDirection.SOUTH_WEST;
            case 15: return SixteenFacingDirection.WEST_SOUTH_WEST;
            default: return FourFacingDirection.WEST;
        }
    }

    default Optional<BlockPosition> getAttachedTo(){
        BlockPosition block = getPosition().getRelative(new Vector3Double(0, -0.1, 0)).toBlockPosition();
        if(block.getBlockType().equals(BlockTypes.AIR)){
            return Optional.empty();
        }
        return Optional.of(block);
    }

}
