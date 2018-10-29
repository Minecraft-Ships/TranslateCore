package org.core.world.direction;

import org.core.vector.types.Vector3Int;

public class FourFacingDirection extends Direction {

    public static final Direction NORTH = new FourFacingDirection("North", 0, 0, -1, "South", "East");
    public static final Direction SOUTH = new FourFacingDirection("South", 0, 0, 1, "North", "West");
    public static final Direction EAST = new FourFacingDirection("East", 1, 0, 0, "West", "South");
    public static final Direction WEST = new FourFacingDirection("West", -1, 0, 0, "East", "North");
    public static final Direction UP = new FourFacingDirection("Up", 0, 1, 0, "Down", "Up");
    public static final Direction DOWN = new FourFacingDirection("Down", 0, -1, 0, "Up", "Down");


    protected FourFacingDirection(String name, Vector3Int asVector, String opposite, String left) {
        super(name, asVector, opposite, left);
    }

    protected FourFacingDirection(String name, int x, int y, int z, String opposite, String left){
        super(name, x, y, z, opposite, left);
    }

    public static Direction[] getFourFacingDirections(){
        return new Direction[] {NORTH, EAST, SOUTH, WEST};
    }
}
