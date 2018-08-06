package org.core.stores.number;

import org.core.stores.SingleStore;

public class SingleNumberStore<A extends Number> extends SingleStore<A> {

    public SingleNumberStore(A value) {
        super(value);
    }

    public SingleNumberStore<Double> add(double value) {
        return new SingleNumberStore<>(((double) getOne()) + value);
    }

    public SingleNumberStore<Float> add(float value) {
        return new SingleNumberStore<>(((float) getOne()) + value);
    }

    public SingleNumberStore<A> add(A value) {
        return new SingleNumberStore<>((A) (Double) ((double) getOne() + (double) value));
    }

    public SingleNumberStore<A> add(SingleNumberStore<A> store) {
        return add(store.getOne());
    }
}
