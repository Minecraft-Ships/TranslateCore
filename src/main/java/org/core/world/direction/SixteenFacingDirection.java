package org.core.world.direction;

import org.array.utils.ArrayUtils;

public class SixteenFacingDirection extends EightFacingDirection {

    public static final Direction NORTH_NORTH_EAST = new SixteenFacingDirection("North_North_East", 0, 0, 0,
                                                                                "South_South_West", "North_North_West",
                                                                                FourFacingDirection.NORTH);
    public static final Direction NORTH_NORTH_WEST = new SixteenFacingDirection("North_North_West", 0, 0, 0,
                                                                                "South_South_East", "South_South_West",
                                                                                FourFacingDirection.NORTH);
    public static final Direction SOUTH_SOUTH_EAST = new SixteenFacingDirection("South_South_East", 0, 0, 0,
                                                                                "North_North_West", "North_North_East",
                                                                                FourFacingDirection.SOUTH);
    public static final Direction SOUTH_SOUTH_WEST = new SixteenFacingDirection("South_South_West", 0, 0, 0,
                                                                                "North_North_East", "South_South_East",
                                                                                FourFacingDirection.SOUTH);

    public static final Direction WEST_SOUTH_WEST = new SixteenFacingDirection("West_South_West", 0, 0, 0,
                                                                               "East_North_East", "North_North_West",
                                                                               FourFacingDirection.WEST);
    public static final Direction WEST_NORTH_WEST = new SixteenFacingDirection("West_North_West", 0, 0, 0,
                                                                               "East_South_East", "South_South_West",
                                                                               FourFacingDirection.WEST);
    public static final Direction EAST_SOUTH_EAST = new SixteenFacingDirection("East_South_East", 0, 0, 0,
                                                                               "West_North_West", "North_North_East",
                                                                               FourFacingDirection.EAST);
    public static final Direction EAST_NORTH_EAST = new SixteenFacingDirection("East_North_East", 0, 0, 0,
                                                                               "West_South_West", "South_South_East",
                                                                               FourFacingDirection.EAST);

    private final FourFacingDirection normal;

    private SixteenFacingDirection(String name,
                                   int x,
                                   int y,
                                   int z,
                                   String opposite,
                                   String left,
                                   FourFacingDirection normal) {
        super(name, x, y, z, opposite, left);
        this.normal = normal;
    }

    public FourFacingDirection normal() {
        return this.normal;
    }

    public static Direction[] getSixteenFacingDirections() {
        return ArrayUtils.join(Direction.class, EightFacingDirection.getEightFacingDirections(), new Direction[]{
                NORTH_NORTH_EAST,
                NORTH_NORTH_WEST,
                SOUTH_SOUTH_EAST,
                SOUTH_SOUTH_WEST,
                WEST_SOUTH_WEST,
                WEST_NORTH_WEST,
                EAST_NORTH_EAST,
                EAST_SOUTH_EAST});
    }
}
