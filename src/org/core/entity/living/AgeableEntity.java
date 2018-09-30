package org.core.entity.living;

public interface AgeableEntity extends LivingEntity {

    public boolean isAdult();
    public AgeableEntity setAdult(boolean check);
}
