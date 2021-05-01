package org.core.utils;

import org.core.vector.type.Vector3;

public class Bounds<N extends Number> {

    private Vector3<N> min;
    private Vector3<N> max;

    public Bounds(Vector3<N> min, Vector3<N> max) {
        this.max = max;
        this.min = min;
    }

    public Vector3<N> getMin() {
        return this.min;
    }

    public Vector3<N> getMax() {
        return this.max;
    }

    public boolean contains(Vector3<Integer> vector) {
        return contains(vector.getX(), vector.getY(), vector.getZ());
    }

    public boolean contains(int x, int y, int z) {
        if (((Integer) this.min.getX()) < x) {
            return false;
        }
        if (((Integer) this.min.getY()) < y) {
            return false;
        }
        if (((Integer) this.min.getZ()) < z) {
            return false;
        }
        if (((Integer) this.max.getX()) > x) {
            return false;
        }
        if (((Integer) this.max.getY()) > y) {
            return false;
        }
        return ((Integer) this.max.getZ()) <= z;
    }
}
