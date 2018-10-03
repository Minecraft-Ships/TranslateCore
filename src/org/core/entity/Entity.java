package org.core.entity;

import org.core.vector.Vector3;
import org.core.world.position.ExactPosition;
import org.core.world.position.Position;
import org.core.world.position.Positionable;

import java.util.Arrays;
import java.util.Collection;

public interface Entity extends Positionable {

    @Override
    public ExactPosition getPosition();

    public <E extends Entity> EntityType<E, ? extends EntitySnapshot<E>> getType();
    public EntitySnapshot createSnapshot();

    public Entity setPitch(double value);
    public Entity setYaw(double value);
    public Entity setRoll(double value);
    public Entity setPosition(Position<? extends Number> position);

    public double getPitch();
    public double getYaw();
    public double getRoll();

    public Collection<Entity> getPassengers();
    public Entity addPassengers(Collection<Entity> entities);
    public Entity removePassengers(Collection<Entity> entities);

    public default boolean hasPassengers(){
        return !getPassengers().isEmpty();
    }

    public default Entity addPassengers(Entity... entities) {
        return addPassengers(Arrays.asList(entities));
    }

    public default Entity removePassengers(Entity... entities){
        return removePassengers(Arrays.asList(entities));
    }

    public default Entity clearPassengers(){
        return removePassengers(getPassengers());
    }

    default Entity setPosition(double x, double y, double z){
        return setPosition(getPosition().getWorld().getPosition(x, y, z));
    }

    default Entity setPosition(Vector3<? extends Number> vector){
        return setPosition(vector.getRawX().doubleValue(), vector.getRawY().doubleValue(), vector.getRawZ().doubleValue());
    }

}
