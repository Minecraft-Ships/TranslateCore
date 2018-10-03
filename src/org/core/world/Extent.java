package org.core.world;

import org.core.world.position.BlockPosition;
import org.core.world.position.ExactPosition;

public interface Extent {

    ExactPosition getPosition(double x, double y, double z);

    BlockPosition getPosition(int x, int y, int z);


    boolean isLoaded();
}
