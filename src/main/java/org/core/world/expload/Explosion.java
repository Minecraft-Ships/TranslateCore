package org.core.world.expload;

import org.core.entity.Entity;
import org.core.world.position.Positionable;
import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.impl.sync.SyncExactPosition;

import java.util.Collection;

public interface Explosion extends Positionable<SyncExactPosition> {

    interface EntityExplosion extends Explosion {

        @Override
        Entity<?> getSource();

        @Override
        default SyncExactPosition getPosition() {
            return this.getSource().getPosition();
        }

    }

    Collection<SyncBlockPosition> getAffectedPositions();

    Object getSource();
}
