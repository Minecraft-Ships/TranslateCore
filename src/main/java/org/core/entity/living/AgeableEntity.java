package org.core.entity.living;

import org.core.entity.Entity;

public interface AgeableEntity<E extends Entity> extends LivingEntity<E> {

    public boolean isAdult();
    public AgeableEntity<E> setAdult(boolean check);
}
