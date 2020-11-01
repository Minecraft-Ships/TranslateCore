package org.core.entity.living;

import org.core.entity.Entity;

public interface AgeableEntity<E extends Entity<?>> extends LivingEntity<E> {

    boolean isAdult();
    AgeableEntity<E> setAdult(boolean check);
}
