package org.core.world.position;

import org.core.world.position.impl.Position;

public interface Positionable<P extends Position<? extends Number>>{

    P getPosition();
}
