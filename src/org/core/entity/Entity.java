package org.core.entity;

import org.core.text.Text;
import org.core.vector.Vector3;
import org.core.vector.types.Vector3Double;
import org.core.world.position.ExactPosition;
import org.core.world.position.Position;
import org.core.world.position.Positionable;

import java.util.Arrays;
import java.util.Collection;

public interface Entity extends Positionable {

    @Override
    ExactPosition getPosition();

    <E extends LiveEntity> EntityType<E, ? extends EntitySnapshot<E>> getType();
    EntitySnapshot<? extends LiveEntity> createSnapshot();

    Entity setPitch(double value);
    Entity setYaw(double value);
    Entity setRoll(double value);
    Entity setPosition(Position<? extends Number> position);
    Entity setGravity(boolean check);
    Entity setVelocity(Vector3Double velocity);
    Entity setCustomName(Text text);
    Entity setCustomNameVisible(boolean visible);

    double getPitch();
    double getYaw();
    double getRoll();
    boolean hasGravity();
    Vector3Double getVelocity();
    Text getCustomName();
    boolean isCustomNameVisible();

    Collection<Entity> getPassengers();
    Entity addPassengers(Collection<Entity> entities);
    Entity removePassengers(Collection<Entity> entities);

    default Entity setVelocity(double x, double y, double z){
        return setVelocity(new Vector3Double(x, y, z));
    }

    default boolean hasPassengers(){
        return !getPassengers().isEmpty();
    }

    default Entity addPassengers(Entity... entities) {
        return addPassengers(Arrays.asList(entities));
    }

    default Entity removePassengers(Entity... entities){
        return removePassengers(Arrays.asList(entities));
    }

    default Entity clearPassengers(){
        return removePassengers(getPassengers());
    }

    default Entity setPosition(double x, double y, double z){
        return setPosition(getPosition().getWorld().getPosition(x, y, z));
    }

    default Entity setPosition(Vector3<? extends Number> vector){
        return setPosition(vector.getRawX().doubleValue(), vector.getRawY().doubleValue(), vector.getRawZ().doubleValue());
    }

}
