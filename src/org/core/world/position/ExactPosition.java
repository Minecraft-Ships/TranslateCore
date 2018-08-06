package org.core.world.position;

import org.core.stores.number.vector.ThreeDoubleVector;

public interface ExactPosition extends Position<Double> {

    @Override
    ThreeDoubleVector getPosition();
}
