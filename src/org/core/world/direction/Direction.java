package org.core.world.direction;

import org.core.vector.types.Vector3Int;

import java.util.Optional;

public abstract class Direction {

    protected Vector3Int vector;
    protected String name;
    protected String left;
    protected String opposite;

    protected Direction(String name, Vector3Int asVector, String opposite, String left){
        this.left = left;
        this.name = name;
        this.vector = asVector;
        this.opposite = opposite;
    }

    protected Direction(String name, int x, int y, int z, String opposite, String left){
        this(name, new Vector3Int(x, y, z), opposite, left);
    }

    public Vector3Int getAsVector(){
        return this.vector;
    }

    public String getName(){
        return this.name;
    }

    public Direction getOpposite(){
        return getDirction(this.opposite).get();
    }

    public Direction getRightAngleLeft(){
        return getDirction(this.left).get();
    }

    public Direction getRightAngleRight(){
        return getDirction(this.left).get().getOpposite();
    }

    public static Direction[] withYDirections(Direction... directions){
        Direction[] directions1 = new Direction[directions.length + 2];
        for(int A = 0; A < directions.length; A++){
            directions1[A] = directions[A];
        }
        directions1[directions.length + 1] = FourFacingDirection.UP;
        directions1[directions.length + 2] = FourFacingDirection.DOWN;
        return directions1;
    }

    public static Optional<Direction> getDirction(String name){
        for(Direction dir : SixteenFacingDirection.getSixteenFacingDirections()){
            if(dir.name.equals(name)){
                return Optional.of(dir);
            }
        }
        return Optional.empty();
    }

}
