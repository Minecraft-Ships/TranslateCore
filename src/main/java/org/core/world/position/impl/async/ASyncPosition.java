package org.core.world.position.impl.async;

import org.core.entity.living.human.player.LivePlayer;
import org.core.platform.PlatformDetails;
import org.core.platform.Plugin;
import org.core.threadsafe.FutureResult;
import org.core.threadsafe.ThreadSafe;
import org.core.vector.Vector3;
import org.core.vector.types.Vector3Int;
import org.core.world.position.block.BlockType;
import org.core.world.position.block.details.BlockDetails;
import org.core.world.position.block.entity.LiveTileEntity;
import org.core.world.position.flags.PositionFlag;
import org.core.world.position.impl.Position;
import org.core.world.position.impl.sync.SyncPosition;

@ThreadSafe(impl = {PlatformDetails.BUKKIT_ID})
public interface ASyncPosition<N extends Number> extends Position<N> {

    FutureResult<SyncPosition<N>> scheduleBlock(Plugin plugin, BlockDetails details, PositionFlag.SetFlag... flags);
    FutureResult<SyncPosition<N>> scheduleBlock(Plugin plugin, BlockDetails details, LivePlayer... player);
    FutureResult<SyncPosition<N>> scheduleReset(Plugin plugin, LivePlayer... player);
    FutureResult<LiveTileEntity> getTileEntity(Plugin plugin);

    default FutureResult<SyncPosition<N>> scheduleBlock(Plugin plugin, BlockType type){
        return this.scheduleBlock(plugin, type.getDefaultBlockDetails());
    }

    default FutureResult<SyncPosition<N>> scheduleBlock(Plugin plugin, BlockDetails details){
        return this.scheduleBlock(plugin, details, new PositionFlag.SetFlag[0]);
    }

    @Override
    default ASyncPosition<N> getRelative(Vector3Int vector){
        return getWorld().getAsyncPosition(getPosition().add(vector));
    }

    @Override
    default ASyncPosition<N> getRelative(Vector3<N> vector){
        return getWorld().getAsyncPosition(vector.add(getPosition()));
    }
}
