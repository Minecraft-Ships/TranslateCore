package org.core.world.position;

import org.core.vector.Vector3;
import org.core.vector.types.Vector3Double;
import org.core.vector.types.Vector3Int;

public interface ExactPosition extends Position<Double> {

    @Override
    Vector3Double getPosition();

    @Override
    ExactPosition getRelative(Vector3<Double> vector);

    BlockPosition toBlockPosition();

    @Override
    default ExactPosition getRelative(Vector3Int vector){
        return getRelative(vector.to(Vector3Double.class));
    }
}
