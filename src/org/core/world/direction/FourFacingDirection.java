package org.core.world.direction;

import org.core.stores.number.vector.ThreeIntegerVector;

public class FourFacingDirection extends Direction {

    public static final Direction NORTH = new FourFacingDirection("North", 0, 0, 0, "East", "South");

    protected FourFacingDirection(String name, ThreeIntegerVector asVector, String opposite, String left) {
        super(name, asVector, opposite, left);
    }

    protected FourFacingDirection(String name, int x, int y, int z, String opposite, String left){
        super(name, x, y, z, opposite, left);
    }

    public static Direction[] getFourFacingDirections(){
        return new Direction[] {NORTH};
    }
}
