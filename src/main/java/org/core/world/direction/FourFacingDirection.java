package org.core.world.direction;

import org.core.vector.type.Vector3;

public class FourFacingDirection extends Direction {

    public static final FourFacingDirection NORTH = new FourFacingDirection("North", 0, 0, -1, "South", "East");
    public static final FourFacingDirection SOUTH = new FourFacingDirection("South", 0, 0, 1, "North", "West");
    public static final FourFacingDirection EAST = new FourFacingDirection("East", 1, 0, 0, "West", "South");
    public static final FourFacingDirection WEST = new FourFacingDirection("West", -1, 0, 0, "East", "North");
    public static final FourFacingDirection UP = new FourFacingDirection("Up", 0, 1, 0, "Down", "Up");
    public static final FourFacingDirection DOWN = new FourFacingDirection("Down", 0, -1, 0, "Up", "Down");
    public static final FourFacingDirection NONE = new FourFacingDirection("None", 0, 0, 0, "None", "None");


    protected FourFacingDirection(String name, Vector3<Integer> asVector, String opposite, String left) {
        super(name, asVector, opposite, left);
    }

    protected FourFacingDirection(String name, int x, int y, int z, String opposite, String left){
        super(name, x, y, z, opposite, left);
    }

    public static Direction[] getFourFacingDirections(){
        return new Direction[] {NORTH, EAST, SOUTH, WEST};
    }
}
