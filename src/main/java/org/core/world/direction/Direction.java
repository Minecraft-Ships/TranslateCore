package org.core.world.direction;

import org.array.utils.ArrayUtils;
import org.core.vector.type.Vector3;

import java.util.Optional;

public class Direction {

    protected final Vector3<Integer> vector;
    protected final String name;
    protected final String left;
    protected final String opposite;

    protected Direction(String name, Vector3<Integer> asVector, String opposite, String left) {
        this.left = left;
        this.name = name;
        this.vector = asVector;
        this.opposite = opposite;
    }

    protected Direction(String name, int x, int y, int z, String opposite, String left) {
        this(name, Vector3.valueOf(x, y, z), opposite, left);
    }

    public Vector3<Integer> getAsVector() {
        return this.vector;
    }

    public String getName() {
        return this.name;
    }

    public Direction getOpposite() {
        Optional<Direction> opDirection = Direction.getDirection(this.opposite);
        if (opDirection.isPresent()) {
            return opDirection.get();
        }
        throw new IllegalStateException("unknown opposite direction from " + this.name + " of " + this.opposite);
    }

    public Direction getRightAngleLeft() {
        return Direction.getDirection(this.left).orElseThrow(() -> new IllegalArgumentException("Cannot get " +
                "direction of " + this.left));
    }

    public Direction getRightAngleRight() {
        return Direction.getDirection(this.left).orElseThrow(() -> new IllegalArgumentException("Cannot get " +
                "direction of " + this.left)).getOpposite();
    }

    public static Direction[] withYDirections(Direction... directions) {
        return ArrayUtils.join(Direction.class, directions, new Direction[]{FourFacingDirection.UP, FourFacingDirection.DOWN});
    }

    public static Optional<Direction> getDirection(int x, int y, int z) {
        return getDirection(Vector3.valueOf(x, y, z));
    }

    public static Optional<Direction> getDirection(Vector3<Integer> vector) {
        for (Direction dir : SixteenFacingDirection.getSixteenFacingDirections()) {
            if (dir.vector.equals(vector)) {
                return Optional.of(dir);
            }
        }
        return Optional.empty();
    }

    public static Optional<Direction> getDirection(String name) {
        for (Direction dir : Direction.withYDirections(SixteenFacingDirection.getSixteenFacingDirections())) {
            if (dir.name.equals(name)) {
                return Optional.of(dir);
            }
        }
        return Optional.empty();
    }

}
