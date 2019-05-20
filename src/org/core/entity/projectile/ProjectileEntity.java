package org.core.entity.projectile;

import org.core.entity.Entity;
import org.core.source.projectile.ProjectileSource;

import java.util.Optional;

public interface ProjectileEntity extends Entity {

    Optional<ProjectileSource> getSource();
    ProjectileEntity setSource(ProjectileSource source);

}
