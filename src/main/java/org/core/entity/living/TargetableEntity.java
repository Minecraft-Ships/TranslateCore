package org.core.entity.living;

import org.core.entity.Entity;

import java.util.Optional;

public interface TargetableEntity<E extends Entity<?>> extends Entity<E> {

    Optional<E> getTargetEntity();
    TargetableEntity<E> setTargetEntity(E entity);

    default TargetableEntity<E> removeTargetEntity(){
        return setTargetEntity(null);
    }
}
