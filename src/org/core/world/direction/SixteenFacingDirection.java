package org.core.world.direction;

import org.core.vector.types.Vector3Int;

public class SixteenFacingDirection extends EightFacingDirection {

    public static final Direction NORTH_NORTH_EAST = new SixteenFacingDirection("North_North_East", 0, 0, 0, "South_South_West", "South_East_East");

    protected SixteenFacingDirection(String name, Vector3Int asVector, String opposite, String left) {
        super(name, asVector, opposite, left);
    }

    protected SixteenFacingDirection(String name, int x, int y, int z, String opposite, String left){
        super(name, x, y, z, opposite, left);
    }

    public static Direction[] getSixteenFacingDirections(){
        return new Direction[] {NORTH, NORTH_EAST};
    }
}
