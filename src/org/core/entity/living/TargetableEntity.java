package org.core.entity.living;

import org.core.entity.Entity;

import java.util.Optional;

public interface TargetableEntity extends LivingEntity {

    public Optional<Entity> getTargetEntity();
    public TargetableEntity setTargetEntity(Entity entity);

    public default TargetableEntity removeTargetEntity(){
        return setTargetEntity(null);
    }
}
