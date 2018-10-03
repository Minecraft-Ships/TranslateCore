package org.core.vector;

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
}
