package org.core.vector;

import org.core.vector.types.Vector3Int;

import java.math.BigDecimal;

public abstract class AbstractVector3<N extends Number> implements Vector3<N> {

    BigDecimal x;
    BigDecimal y;
    BigDecimal z;

    protected abstract Vector3<N> createNew(BigDecimal x, BigDecimal y, BigDecimal z);

    public AbstractVector3(BigDecimal x, BigDecimal y, BigDecimal z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Vector3<N> add(Vector3Int vector){
        BigDecimal x = new BigDecimal(this.x.doubleValue() + vector.getX());
        BigDecimal y = new BigDecimal(this.y.doubleValue() + vector.getY());
        BigDecimal z = new BigDecimal(this.z.doubleValue() + vector.getZ());
        return this.createNew(x, y, z);
    }

    @Override
    public Vector3<N> add(Vector3<N> vector) {
        BigDecimal x = new BigDecimal(this.x.doubleValue() + vector.getRawX().doubleValue());
        BigDecimal y = new BigDecimal(this.y.doubleValue() + vector.getRawY().doubleValue());
        BigDecimal z = new BigDecimal(this.z.doubleValue() + vector.getRawZ().doubleValue());
        return this.createNew(x, y, z);
    }

    @Override
    public Vector3<N> minus(Vector3<N> vector) {
        BigDecimal x = new BigDecimal(this.x.doubleValue() - vector.getRawX().doubleValue());
        BigDecimal y = new BigDecimal(this.y.doubleValue() - vector.getRawY().doubleValue());
        BigDecimal z = new BigDecimal(this.z.doubleValue() - vector.getRawZ().doubleValue());
        return this.createNew(x, y, z);
    }

    @Override
    public Vector3<N> devide(BigDecimal amount) {
        BigDecimal x = new BigDecimal(this.x.doubleValue() / amount.doubleValue());
        BigDecimal y = new BigDecimal(this.y.doubleValue() / amount.doubleValue());
        BigDecimal z = new BigDecimal(this.z.doubleValue() / amount.doubleValue());
        return this.createNew(x, y, z);
    }

    @Override
    public Vector3<N> multiply(BigDecimal amount) {
        BigDecimal x = new BigDecimal(this.x.doubleValue() * amount.doubleValue());
        BigDecimal y = new BigDecimal(this.y.doubleValue() * amount.doubleValue());
        BigDecimal z = new BigDecimal(this.z.doubleValue() * amount.doubleValue());
        return this.createNew(x, y, z);
    }

    @Override
    public BigDecimal getRawX() {
        return this.x;
    }

    @Override
    public BigDecimal getRawY() {
        return this.y;
    }

    @Override
    public BigDecimal getRawZ() {
        return this.z;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Vector3)){
            System.out.println("Failed, not Vector3 but instead a " + obj.getClass().getName());
            return false;
        }
        Vector3<? extends Number> vector = (Vector3<? extends Number>)obj;
        System.out.println("Vector: " + getX() + "," + getY() + "," + getZ() + " - " + vector.getX() + "," + vector.getY() + "," + vector.getZ());
        if(vector.getRawX().doubleValue() != this.x.doubleValue()){
            System.out.println("Failed on X: " + vector.getRawX().doubleValue() + ": " + this.x.doubleValue());
            return false;
        }
        if(vector.getRawY().doubleValue() != this.y.doubleValue()){
            System.out.println("Failed on Y: " + vector.getRawY().doubleValue() + ": " + this.y.doubleValue());
            return false;
        }
        if(vector.getRawZ().doubleValue() != this.z.doubleValue()){
            System.out.println("Failed on Z: " + vector.getRawZ().doubleValue() + ": " + this.z.doubleValue());
            return false;
        }
        return true;
    }
}
