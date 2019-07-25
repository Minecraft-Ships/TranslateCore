package org.core.world.direction;

import org.core.CorePlugin;
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
        Optional<Direction> opDirection = getDirction(this.opposite);
        if(opDirection.isPresent()){
            return opDirection.get();
        }
        System.out.println("unknown opposite direction from " + this.name + " of " + this.opposite);
        return opDirection.get();
    }

    public Direction getRightAngleLeft(){
        return getDirction(this.left).get();
    }

    public Direction getRightAngleRight(){
        return getDirction(this.left).get().getOpposite();
    }

    public static Direction[] withYDirections(Direction... directions){
        return CorePlugin.join(directions, new Direction[] {FourFacingDirection.UP, FourFacingDirection.DOWN});
    }

    public static Optional<Direction> getDirection(int x, int y, int z){
        return getDirection(new Vector3Int(x, y, z));
    }

    public static Optional<Direction> getDirection(Vector3Int vector){
        for(Direction dir : SixteenFacingDirection.getSixteenFacingDirections()){
            if(dir.vector.equals(vector)){
                return Optional.of(dir);
            }
        }
        return Optional.empty();
    }

    public static Optional<Direction> getDirction(String name){
        for(Direction dir : Direction.withYDirections(SixteenFacingDirection.getSixteenFacingDirections())){
            if(dir.name.equals(name)){
                return Optional.of(dir);
            }
        }
        return Optional.empty();
    }

}
