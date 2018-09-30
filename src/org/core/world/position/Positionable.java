package org.core.world.position;

public interface Positionable <T extends Position<? extends Number>> {

    public T getPosition();
}
