package org.core.entity.living;

import org.core.entity.Entity;

import java.util.Optional;

public interface TargetableEntity extends LivingEntity {

    Optional<Entity> getTargetEntity();
    TargetableEntity setTargetEntity(Entity entity);

    default TargetableEntity removeTargetEntity(){
        return setTargetEntity(null);
    }
}
