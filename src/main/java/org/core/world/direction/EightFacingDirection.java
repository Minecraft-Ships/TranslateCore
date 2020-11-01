package org.core.world.direction;

import org.core.vector.type.Vector3;

public class EightFacingDirection extends FourFacingDirection {

    public static final Direction NORTH_EAST = new EightFacingDirection("North_East", 1, 0, -1, "South_West", "South_East");
    public static final Direction NORTH_WEST = new EightFacingDirection("North_West", -1, 0, -1, "South_East", "North_East");
    public static final Direction SOUTH_WEST = new EightFacingDirection("South_West", -1, 0, 1, "North_East", "North_West");
    public static final Direction SOUTH_EAST = new EightFacingDirection("South_East", 1, 0, 1, "North_West", "South_West");

    protected EightFacingDirection(String name, Vector3<Integer> asVector, String opposite, String left) {
        super(name, asVector, opposite, left);
    }

    protected EightFacingDirection(String name, int x, int y, int z, String opposite, String left){
        super(name, x, y, z, opposite, left);
    }

    public static Direction[] getEightFacingDirections(){
        return new Direction[] {WEST, NORTH_WEST, NORTH, NORTH_EAST, EAST, SOUTH_EAST, SOUTH, SOUTH_WEST};
    }
}
