package org.core.world;

import org.core.entity.LiveEntity;
import org.core.platform.PlatformDetails;
import org.core.threadsafe.ThreadSafe;
import org.core.vector.type.Vector3;
import org.core.world.position.block.entity.LiveTileEntity;
import org.core.world.position.impl.async.ASyncBlockPosition;
import org.core.world.position.impl.async.ASyncExactPosition;
import org.core.world.position.impl.async.ASyncPosition;
import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.impl.sync.SyncExactPosition;
import org.core.world.position.impl.sync.SyncPosition;

import java.util.Set;

public interface Extent {

    SyncExactPosition getPosition(double x, double y, double z);
    @ThreadSafe(impl = {PlatformDetails.BUKKIT_ID}) ASyncExactPosition getAsyncPosition(double x, double y, double z);
    SyncBlockPosition getPosition(int x, int y, int z);
    @ThreadSafe(impl = {PlatformDetails.BUKKIT_ID}) ASyncBlockPosition getAsyncPosition(int x, int y, int z);
    boolean isLoaded();
    Set<LiveEntity> getEntities();
    Set<LiveTileEntity> getTileEntities();

    default <N extends Number> SyncPosition<N> getPosition(Vector3<N> vector){
        if(vector.getX() instanceof Integer){
            return (SyncPosition<N>) this.getPosition(vector.getX().intValue(), vector.getY().intValue(), vector.getZ().intValue());
        }
        if (vector.getX() instanceof Double) {
            return (SyncPosition<N>) this.getPosition(vector.getX().doubleValue(), vector.getY().doubleValue(), vector.getZ().doubleValue());
        }
        System.err.println("Extent.getPosition(Vector3<" + vector.getX().getClass().getSimpleName() + ") is not supported. Defaulting to ExactPosition");
        return (SyncPosition<N>) this.getPosition(vector.getX().doubleValue(), vector.getY().doubleValue(), vector.getZ().doubleValue());
    }

    default <N extends Number> ASyncPosition<N> getAsyncPosition(Vector3<N> vector){
        if(vector.getX() instanceof Integer){
            return (ASyncPosition<N>) this.getAsyncPosition(vector.getX().intValue(), vector.getY().intValue(), vector.getZ().intValue());
        }
        if (vector.getX() instanceof Double) {
            return (ASyncPosition<N>) this.getAsyncPosition(vector.getX().doubleValue(), vector.getY().doubleValue(), vector.getZ().doubleValue());
        }
        System.err.println("Extent.getPosition(Vector3<" + vector.getX().getClass().getSimpleName() + ") is not supported. Defaulting to ExactPosition");
        return (ASyncPosition<N>) this.getAsyncPosition(vector.getX().doubleValue(), vector.getY().doubleValue(), vector.getZ().doubleValue());
    }
}
