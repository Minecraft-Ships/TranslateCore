package org.core.entity.scene.minecart.type.rideable;

import org.core.entity.Entity;
import org.core.entity.scene.minecart.Minecart;

import java.util.Collection;
import java.util.Optional;

public interface RideableMinecart<E extends Entity<?>> extends Minecart<E> {

    @Deprecated
    Collection<E> getPassengers();

    default boolean isEmpty(){
        return this.getPassengers().isEmpty();
    }

    default Optional<E> getRider(){
        Collection<E> passengers = this.getPassengers();
        if (passengers.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(passengers.iterator().next());
    }

}
