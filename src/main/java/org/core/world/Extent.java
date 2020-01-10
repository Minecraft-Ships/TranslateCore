package org.core.world;

import org.core.entity.LiveEntity;
import org.core.vector.Vector3;
import org.core.vector.types.Vector3Double;
import org.core.vector.types.Vector3Int;
import org.core.world.position.BlockPosition;
import org.core.world.position.ExactPosition;
import org.core.world.position.Position;
import org.core.world.position.block.entity.LiveTileEntity;

import java.util.Set;

public interface Extent {

    ExactPosition getPosition(double x, double y, double z);

    BlockPosition getPosition(int x, int y, int z);

    boolean isLoaded();

    Set<LiveEntity> getEntities();

    Set<LiveTileEntity> getTileEntities();

    @SuppressWarnings("unchecked")
    default <N extends Number> Position<N> getPosition(Vector3<N> vector){
        if(vector instanceof Vector3Int){
            Vector3Int intVect = (Vector3Int)vector;
            return (Position<N>)getPosition(intVect.getX(), intVect.getY(), intVect.getZ());
        }else if(vector instanceof Vector3Double){
            Vector3Double doubleVect = (Vector3Double)vector;
            return (Position<N>)getPosition(doubleVect.getX(), doubleVect.getY(), doubleVect.getZ());
        }
        System.err.println("Extent.getPosition(Vector3<" + vector.getX().getClass() + "> is not supported. Defaulting to BlockPosition");
        return (Position<N>)getPosition(vector.getRawX().intValue(), vector.getRawY().intValue(), vector.getRawZ().intValue());
    }
}
