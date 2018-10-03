package org.core.world.position;

import org.core.vector.types.Vector3Double;

public interface ExactPosition extends Position<Double> {

    @Override
    Vector3Double getPosition();
}
