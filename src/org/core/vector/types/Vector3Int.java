package org.core.vector.types;

import org.core.vector.AbstractVector3;
import org.core.vector.Vector3;

import java.math.BigDecimal;

public class Vector3Int extends AbstractVector3<Integer> {

    public Vector3Int(int x, int y, int z){
        this(new BigDecimal(x), new BigDecimal(y), new BigDecimal(z));
    }

    public Vector3Int(BigDecimal x, BigDecimal y, BigDecimal z) {
        super(x, y, z);
    }

    @Override
    protected Vector3<Integer> createNew(BigDecimal x, BigDecimal y, BigDecimal z) {
        return new Vector3Int(x, y, z);
    }

    @Override
    public Integer getX() {
        return getRawX().intValueExact();
    }

    @Override
    public Integer getY() {
        return getRawY().intValueExact();
    }

    @Override
    public Integer getZ() {
        return getRawZ().intValueExact();
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Vector3Int)){
            return super.equals(obj);
        }
        Vector3Int vector = (Vector3Int)obj;
        System.out.println("Vector: " + getX() + "," + getY() + "," + getZ() + " - " + vector.getX() + "," + vector.getY() + "," + vector.getZ());
        if(vector.getX().intValue() != this.getX().intValue()){
            System.out.println("Failed on X: " + vector.getX() + ": " + this.getX());
            return false;
        }
        if(vector.getY().intValue() != this.getY().intValue()){
            System.out.println("Failed on Y: " + vector.getY() + ": " + this.getY());
            return false;
        }
        if(vector.getZ().intValue() != this.getZ().intValue()){
            System.out.println("Failed on Z: " + vector.getZ() + ": " + this.getZ());
            return false;
        }
        return true;
    }
}
