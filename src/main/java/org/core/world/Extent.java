package org.core.world;

import org.core.entity.LiveEntity;
import org.core.platform.PlatformDetails;
import org.core.threadsafe.ThreadSafe;
import org.core.vector.Vector3;
import org.core.vector.types.Vector3Double;
import org.core.vector.types.Vector3Int;
import org.core.world.position.impl.async.ASyncBlockPosition;
import org.core.world.position.impl.async.ASyncExactPosition;
import org.core.world.position.impl.async.ASyncPosition;
import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.impl.sync.SyncExactPosition;
import org.core.world.position.impl.sync.SyncPosition;
import org.core.world.position.block.entity.LiveTileEntity;

import java.util.Set;

public interface Extent {

    SyncExactPosition getPosition(double x, double y, double z);
    @ThreadSafe(impl = {PlatformDetails.BUKKIT_ID}) ASyncExactPosition getAsyncPosition(double x, double y, double z);
    SyncBlockPosition getPosition(int x, int y, int z);
    @ThreadSafe(impl = {PlatformDetails.BUKKIT_ID}) ASyncBlockPosition getAsyncPosition(int x, int y, int z);
    boolean isLoaded();
    Set<LiveEntity> getEntities();
    Set<LiveTileEntity> getTileEntities();

    @SuppressWarnings("unchecked")
    default <N extends Number> SyncPosition<N> getPosition(Vector3<N> vector){
        if(vector instanceof Vector3Int){
            Vector3Int intVect = (Vector3Int)vector;
            return (SyncPosition<N>)getPosition(intVect.getX(), intVect.getY(), intVect.getZ());
        }else if(vector instanceof Vector3Double){
            Vector3Double doubleVect = (Vector3Double)vector;
            return (SyncPosition<N>)getPosition(doubleVect.getX(), doubleVect.getY(), doubleVect.getZ());
        }
        System.err.println("Extent.getPosition(Vector3<" + vector.getX().getClass() + "> is not supported. Defaulting to BlockPosition");
        return (SyncPosition<N>)getPosition(vector.getRawX().intValue(), vector.getRawY().intValue(), vector.getRawZ().intValue());
    }

    @SuppressWarnings("unchecked")
    default <N extends Number> ASyncPosition<N> getAsyncPosition(Vector3<N> vector){
        if(vector instanceof Vector3Int){
            Vector3Int intVect = (Vector3Int)vector;
            return (ASyncPosition<N>)getAsyncPosition(intVect.getX(), intVect.getY(), intVect.getZ());
        }else if(vector instanceof Vector3Double){
            Vector3Double doubleVect = (Vector3Double)vector;
            return (ASyncPosition<N>)getAsyncPosition(doubleVect.getX(), doubleVect.getY(), doubleVect.getZ());
        }
        System.err.println("Extent.getPosition(Vector3<" + vector.getX().getClass() + "> is not supported. Defaulting to BlockPosition");
        return (ASyncPosition<N>)getAsyncPosition(vector.getRawX().intValue(), vector.getRawY().intValue(), vector.getRawZ().intValue());
    }
}
