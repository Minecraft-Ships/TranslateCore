package org.core.world.position.block.details;

import org.core.world.position.Positionable;
import org.core.world.position.impl.BlockPosition;
import org.core.world.position.impl.async.ASyncBlockPosition;
import org.core.world.position.impl.sync.SyncBlockPosition;

public interface BlockSnapshot<P extends BlockPosition> extends BlockDetails, Positionable<P> {

    interface SyncBlockSnapshot extends BlockSnapshot<SyncBlockPosition> {

        AsyncBlockSnapshot asAsynced();

        @Override
        BlockSnapshot.SyncBlockSnapshot createCopyOf();
    }

    interface AsyncBlockSnapshot extends BlockSnapshot<ASyncBlockPosition> {

        @Override
        BlockSnapshot.AsyncBlockSnapshot createCopyOf();
    }

    @Override
    BlockSnapshot<P> createCopyOf();
}
