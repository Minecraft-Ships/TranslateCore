package org.core.entity;

import org.core.stores.number.TripleNumberStore;
import org.core.world.position.ExactPosition;
import org.core.world.position.Position;
import org.core.world.position.Positionable;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public interface Entity extends Positionable<ExactPosition> {

    public EntityType<? extends Entity> getType();
    public EntitySnapshot createSnapshot();

    public Entity setPosition(Position<? extends Number> position);
    public Entity setPosition(TripleNumberStore<? extends Number> vector);

    public double getPitch();
    public double getYaw();
    public double getRoll();

    public List<Entity> getPassengers();
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

}
