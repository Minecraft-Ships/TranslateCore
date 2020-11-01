package org.core.entity.projectile;

import org.core.entity.Entity;
import org.core.source.projectile.ProjectileSource;

import java.util.Optional;

public interface ProjectileEntity<E extends Entity<?>> extends Entity<E> {

    Optional<ProjectileSource> getSource();
    ProjectileEntity<E> setSource(ProjectileSource source);

}
