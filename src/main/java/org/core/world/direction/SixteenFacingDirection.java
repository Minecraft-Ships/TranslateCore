package org.core.world.direction;

import org.array.utils.ArrayUtils;
import org.core.vector.type.Vector3;

public class SixteenFacingDirection extends EightFacingDirection {

    public static final Direction NORTH_NORTH_EAST = new SixteenFacingDirection("North_North_East", 0, 0, 0, "South_South_West", "North_North_West");
    public static final Direction NORTH_NORTH_WEST = new SixteenFacingDirection("North_North_West", 0,0,0, "South_South_East", "South_South_West");
    public static final Direction SOUTH_SOUTH_EAST = new SixteenFacingDirection("South_South_East", 0, 0, 0, "North_North_West", "North_North_East");
    public static final Direction SOUTH_SOUTH_WEST = new SixteenFacingDirection("South_South_West", 0, 0, 0, "North_North_East", "South_South_East");

    public static final Direction WEST_SOUTH_WEST = new SixteenFacingDirection("West_South_West", 0, 0, 0, "East_North_East", "North_North_West");
    public static final Direction WEST_NORTH_WEST = new SixteenFacingDirection("West_North_West", 0, 0, 0, "East_South_East", "South_South_West");
    public static final Direction EAST_SOUTH_EAST = new SixteenFacingDirection("East_South_East", 0, 0, 0, "West_North_West", "North_North_East");
    public static final Direction EAST_NORTH_EAST = new SixteenFacingDirection("East_North_East", 0, 0, 0, "West_South_West", "South_South_East");

    protected SixteenFacingDirection(String name, Vector3<Integer> asVector, String opposite, String left) {
        super(name, asVector, opposite, left);
    }

    protected SixteenFacingDirection(String name, int x, int y, int z, String opposite, String left){
        super(name, x, y, z, opposite, left);
    }

    public static Direction[] getSixteenFacingDirections(){
        return ArrayUtils.join(Direction.class, EightFacingDirection.getEightFacingDirections(), new Direction[] {NORTH_EAST});
    }
}
