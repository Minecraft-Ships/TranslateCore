package org.core.vector.types;

import org.core.vector.AbstractVector3;
import org.core.vector.Vector3;

import java.math.BigDecimal;

public class Vector3Double extends AbstractVector3<Double> {

    public Vector3Double(double x, double y, double z){
        this(new BigDecimal(x), new BigDecimal(y), new BigDecimal(z));
    }

    public Vector3Double(BigDecimal x, BigDecimal y, BigDecimal z) {
        super(x, y, z);
    }

    @Override
    protected Vector3<Double> createNew(BigDecimal x, BigDecimal y, BigDecimal z) {
        return new Vector3Double(x, y, z);
    }

    @Override
    public Double getX() {
        return getRawX().doubleValue();
    }

    @Override
    public Double getY() {
        return getRawY().doubleValue();
    }

    @Override
    public Double getZ() {
        return getRawZ().doubleValue();
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Vector3Double)){
            return super.equals(obj);
        }
        Vector3Double vector = (Vector3Double)obj;
        if(vector.getX().doubleValue() != this.getX().doubleValue()){
            return false;
        }
        if(vector.getY().doubleValue() != this.getY().doubleValue()){
            return false;
        }
        if(vector.getZ().doubleValue() != this.getZ().doubleValue()){
            return false;
        }
        return true;
    }
}
