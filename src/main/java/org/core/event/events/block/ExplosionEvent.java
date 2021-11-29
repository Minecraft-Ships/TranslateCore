package org.core.event.events.block;

import org.core.event.PlatformEvent;
import org.core.world.expload.Explosion;

public interface ExplosionEvent extends PlatformEvent {

    Explosion getExplosion();

    interface Post extends ExplosionEvent {

        @Override
        Explosion.ExplosionSnapshot getExplosion();
    }

}
