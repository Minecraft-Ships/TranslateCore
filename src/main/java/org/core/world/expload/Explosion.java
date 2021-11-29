package org.core.world.expload;

import org.core.entity.Entity;
import org.core.world.position.Positionable;
import org.core.world.position.block.details.BlockSnapshot;
import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.impl.sync.SyncExactPosition;

import java.util.Collection;
import java.util.stream.Collectors;

public interface Explosion extends Positionable<SyncExactPosition> {

    interface EntityExplosion extends Explosion {

        @Override
        Entity<?> getSource();

        @Override
        default SyncExactPosition getPosition() {
            return this.getSource().getPosition();
        }
    }

    interface ExplosionSnapshot extends Explosion {

        Collection<BlockSnapshot.SyncBlockSnapshot> getBlocks();

        default Collection<SyncBlockPosition> getAffectedPositions() {
            return this
                    .getBlocks()
                    .parallelStream()
                    .map(Positionable::getPosition)
                    .collect(Collectors.toSet());
        }

    }

    Collection<SyncBlockPosition> getAffectedPositions();

    Object getSource();
}
