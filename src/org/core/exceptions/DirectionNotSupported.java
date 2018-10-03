package org.core.exceptions;

import org.core.world.direction.Direction;

import java.io.IOException;

public class DirectionNotSupported extends IOException {

    public DirectionNotSupported(Direction direction, String type){
        super("Direction " + direction.getName() + " is not supported by " + type);
    }
}
