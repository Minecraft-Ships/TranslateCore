package org.core.world.position.block.details.data.keyed;

import org.core.world.direction.Direction;

import java.util.Collection;

public interface MultiDirectionalKeyedData extends KeyedData<Collection<Direction>> {

    Collection<Direction> getSupportedDirections();

}
