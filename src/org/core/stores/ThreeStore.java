package org.core.stores;

public class ThreeStore<A extends Object, B extends Object, C extends Object> extends TwoStore<A, B> {

    protected C three;

    public ThreeStore(A value1, B value2, C value3) {
        super(value1, value2);
        this.three = value3;
    }

    public C getThree() {
        return three;
    }

    public void setThree(C value) {
        this.three = value;
    }
}
