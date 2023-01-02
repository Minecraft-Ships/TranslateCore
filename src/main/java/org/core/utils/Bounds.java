package org.core.utils;

import org.core.vector.type.Vector3;

public class Bounds<N extends Number> {

    private Vector3<? extends N> min;
    private Vector3<? extends N> max;

    public Bounds(Vector3<? extends N> min, Vector3<? extends N> max) {
        this.max = max;
        this.min = min;
    }

    public Vector3<? extends N> first() {
        return this.min;
    }

    public Vector3<? extends N> last() {
        return this.max;
    }

    public void addX(int x) {
        if (this.min.getX().doubleValue() > this.max.getX().doubleValue()) {
            this.min = this.min.plus(x, 0, 0);
            return;
        }
        this.max = this.max.plus(x, 0, 0);
    }

    public void addY(int y) {
        if (this.min.getY().doubleValue() > this.max.getY().doubleValue()) {
            this.min = this.min.plus(0, y, 0);
            return;
        }
        this.max = this.max.plus(0, y, 0);
    }

    public void addZ(int z) {
        if (this.min.getZ().doubleValue() > this.max.getZ().doubleValue()) {
            this.min = this.min.plus(0, 0, z);
            return;
        }
        this.max = this.max.plus(0, 0, z);
    }

    public Number[] getMax() {
        N x = this.max.getX();
        N y = this.max.getY();
        N z = this.max.getZ();
        if (x.doubleValue() < this.min.getX().doubleValue()) {
            x = this.min.getX();
        }
        if (y.doubleValue() < this.min.getY().doubleValue()) {
            y = this.min.getY();
        }
        if (z.doubleValue() < this.min.getZ().doubleValue()) {
            z = this.min.getZ();
        }
        return new Number[]{x, y, z};
    }

    public Vector3<Integer> getIntMax() {
        Number[] num = this.getMax();
        return Vector3.valueOf(num[0].intValue(), num[1].intValue(), num[2].intValue());
    }

    public Vector3<Double> getDoubleMax() {
        Number[] num = this.getMax();
        return Vector3.valueOf(num[0].doubleValue(), num[1].doubleValue(), num[2].doubleValue());
    }

    public Number[] getMin() {
        N x = this.min.getX();
        N y = this.min.getY();
        N z = this.min.getZ();
        if (x.doubleValue() > this.max.getX().doubleValue()) {
            x = this.max.getX();
        }
        if (y.doubleValue() > this.max.getY().doubleValue()) {
            y = this.max.getY();
        }
        if (z.doubleValue() > this.max.getZ().doubleValue()) {
            z = this.max.getZ();
        }
        return new Number[]{x, y, z};
    }

    public Vector3<Integer> getIntMin() {
        Number[] num = this.getMin();
        return Vector3.valueOf(num[0].intValue(), num[1].intValue(), num[2].intValue());
    }

    public Vector3<Double> getDoubleMin() {
        Number[] num = this.getMin();
        return Vector3.valueOf(num[0].doubleValue(), num[1].doubleValue(), num[2].doubleValue());
    }

    public boolean contains(Vector3<Integer> vector) {
        return this.contains(vector.getX(), vector.getY(), vector.getZ());
    }

    public boolean contains(int x, int y, int z) {
        Vector3<Integer> min = this.getIntMin();
        Vector3<Integer> max = this.getIntMax();

        if (min.getX() > x) {
            return false;
        }
        if (min.getY() > y) {
            return false;
        }
        if (min.getZ() > z) {
            return false;
        }
        if (max.getX() < x) {
            return false;
        }
        if (max.getY() < y) {
            return false;
        }
        return max.getZ() > z;
    }
}
