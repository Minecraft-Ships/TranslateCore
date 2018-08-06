package org.core.stores;

public class TwoStore<A extends Object, B extends Object> extends SingleStore<A> {

    protected B two;

    public TwoStore(A value1, B value2) {
        super(value1);
        this.two = value2;
    }

    public B getTwo() {
        return this.two;
    }

    public void setTwo(B value) {
        this.two = value;
    }
}
