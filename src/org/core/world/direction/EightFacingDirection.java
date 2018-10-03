package org.core.world.direction;


import org.core.vector.types.Vector3Int;

public class EightFacingDirection extends FourFacingDirection {

    public static final Direction NORTH_EAST = new EightFacingDirection("North_East", 0, 0, 0, "South_West", "South_East");
    public static final Direction NORTH_WEST = new EightFacingDirection("North_West", 0, 0, 0, "South_East", "North_East");
    public static final Direction SOUTH_WEST = new EightFacingDirection("South_West", 0, 0, 0, "North_East", "North_West");
    public static final Direction SOUTH_EAST = new EightFacingDirection("South_East", 0, 0, 0, "North_West", "South_West");

    protected EightFacingDirection(String name, Vector3Int asVector, String opposite, String left) {
        super(name, asVector, opposite, left);
    }

    protected EightFacingDirection(String name, int x, int y, int z, String opposite, String left){
        super(name, x, y, z, opposite, left);
    }

    public static Direction[] getEightFacingDirections(){
        return new Direction[] {WEST, NORTH_WEST, NORTH, NORTH_EAST, EAST, SOUTH_EAST, SOUTH, SOUTH_WEST};
    }
}
