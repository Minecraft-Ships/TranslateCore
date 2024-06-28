package org.core.world.expload;

import org.core.entity.Entity;
import org.core.world.position.Positionable;
import org.core.world.position.block.details.BlockSnapshot;
import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.impl.sync.SyncExactPosition;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        @Override
        default Stream<SyncBlockPosition> getAffectedBlockPositions() {
            return this.getBlocks().parallelStream().map(Positionable::getPosition);
        }

    }

    @Deprecated(forRemoval = true)
    default Collection<SyncBlockPosition> getAffectedPositions() {
        return this.getAffectedBlockPositions().collect(Collectors.toSet());
    }

    Stream<SyncBlockPosition> getAffectedBlockPositions();

    Object getSource();
}
