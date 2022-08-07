package org.core.world.position.block.details;

import org.core.world.position.Positionable;
import org.core.world.position.impl.BlockPosition;
import org.core.world.position.impl.async.ASyncBlockPosition;
import org.core.world.position.impl.sync.SyncBlockPosition;

public interface BlockSnapshot<P extends BlockPosition> extends BlockDetails, Positionable<P> {

    @Override
    BlockSnapshot<P> createCopyOf();

    interface SyncBlockSnapshot extends BlockSnapshot<SyncBlockPosition> {

        AsyncBlockSnapshot asAsynced();

        @Override
        BlockSnapshot.SyncBlockSnapshot createCopyOf();

        default void restore() {
            this.getPosition().setBlock(this);
        }
    }

    interface AsyncBlockSnapshot extends BlockSnapshot<ASyncBlockPosition> {

        @Override
        BlockSnapshot.AsyncBlockSnapshot createCopyOf();
    }
}
