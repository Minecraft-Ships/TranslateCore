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
        return getRawX().intValue();
    }

    @Override
    public Integer getY() {
        return getRawY().intValue();
    }

    @Override
    public Integer getZ() {
        return getRawZ().intValue();
    }
}
