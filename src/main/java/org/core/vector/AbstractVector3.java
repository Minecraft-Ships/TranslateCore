package org.core.vector;

import org.core.vector.types.Vector3Int;

import java.math.BigDecimal;

/**
 * A base abstract Vector for assisting development of Vectors
 * @param <N> the Number type
 */
public abstract class AbstractVector3<N extends Number> implements Vector3<N> {

    protected BigDecimal x;
    protected BigDecimal y;
    protected BigDecimal z;

    /**
     * Creates a new instance of the vector with the values specified
     * @param x The new value for X
     * @param y The new value for Y
     * @param z The new value of Z
     * @return The new instance of Vector
     */
    protected abstract Vector3<N> createNew(BigDecimal x, BigDecimal y, BigDecimal z);

    protected AbstractVector3(BigDecimal x, BigDecimal y, BigDecimal z){
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
    public Vector3<N> divide(BigDecimal amount) {
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

    /**
     * Checks that the vector is equal to another vector.
     * The numbers are compared in X Y and Z, does not
     * matter about the class.
     * @param obj the obj to compare
     * @return if the vectors equal
     */
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Vector3)){
            return false;
        }
        Vector3<? extends Number> vector = (Vector3<? extends Number>)obj;
        if(vector.getRawX().doubleValue() != this.x.doubleValue()){
            return false;
        }
        if(vector.getRawY().doubleValue() != this.y.doubleValue()){
            return false;
        }
        if(vector.getRawZ().doubleValue() != this.z.doubleValue()){
            return false;
        }
        return true;
    }

    /**
     * Gets a String value of the Vector
     * @return {X, Y, Z}
     */
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + "{" + this.x + "," + this.y + "," + this.z + ")";
    }
}
