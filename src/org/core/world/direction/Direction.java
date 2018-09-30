package org.core.world.direction;

import org.core.stores.number.vector.ThreeIntegerVector;

import java.util.Optional;

public abstract class Direction {

    protected ThreeIntegerVector vector;
    protected String name;
    protected String left;
    protected String opposite;

    protected Direction(String name, ThreeIntegerVector asVector, String opposite, String left){
        this.left = left;
        this.name = name;
        this.vector = asVector;
        this.opposite = opposite;
    }

    protected Direction(String name, int x, int y, int z, String opposite, String left){
        this(name, new ThreeIntegerVector(x, y, z), opposite, left);
    }

    public ThreeIntegerVector getAsVector(){
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

    public Optional<Direction> getDirction(String name){
        for(Direction dir : SixteenFacingDirection.getSixteenFacingDirections()){
            if(dir.name.equals(name)){
                return Optional.of(dir);
            }
        }
        return Optional.empty();
    }

}
