package org.core.world.position;

import org.core.stores.number.vector.ThreeIntegerVector;

public interface BlockPosition extends Position<Integer> {

    @Override
    ThreeIntegerVector getPosition();
}
