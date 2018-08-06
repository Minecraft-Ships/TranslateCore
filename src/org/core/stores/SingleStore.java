package org.core.stores;

public class SingleStore<A extends Object> {

    protected A one;

    public SingleStore(A value) {
        this.one = value;
    }

    public A getOne() {
        return this.one;
    }

    public void setOne(A one) {
        this.one = one;
    }
}
