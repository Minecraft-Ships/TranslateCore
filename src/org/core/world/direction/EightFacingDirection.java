package org.core.world.direction;

import org.core.stores.number.vector.ThreeIntegerVector;

public class EightFacingDirection extends FourFacingDirection {

    public static final Direction NORTH_EAST = new EightFacingDirection("North_East", 0, 0, 0, "South_West", "South_East");

    protected EightFacingDirection(String name, ThreeIntegerVector asVector, String opposite, String left) {
        super(name, asVector, opposite, left);
    }

    protected EightFacingDirection(String name, int x, int y, int z, String opposite, String left){
        super(name, x, y, z, opposite, left);
    }

    public static Direction[] getEightFacingDirections(){
        return new Direction[] {NORTH, NORTH_EAST};
    }
}
