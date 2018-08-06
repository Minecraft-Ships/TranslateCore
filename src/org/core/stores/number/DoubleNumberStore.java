package org.core.stores.number;

import org.core.stores.TwoStore;
import org.core.stores.number.vector.TwoDoubleVector;

public class DoubleNumberStore<A extends Number> extends TwoStore<A, A> {

    public DoubleNumberStore(A value1, A value2) {
        super(value1, value2);
    }

    public DoubleNumberStore<A> add(DoubleNumberStore<A> store) {
        A value1 = (A) (Double) ((double) store.getOne() + (double) getOne());
        A valueTwo = (A) (Double) ((double) store.getTwo() + (double) getTwo());
        return new DoubleNumberStore<>(value1, valueTwo);
    }

    public DoubleNumberStore<A> subtract(DoubleNumberStore<A> store) {
        A value1 = (A) (Double) ((double) getOne() - (double) store.getOne());
        A value2 = (A) (Double) ((double) getTwo() - (double) store.getTwo());
        return new DoubleNumberStore<>(value1, value2);
    }

    public TwoDoubleVector add(TwoDoubleVector store) {
        double value1 = store.getOne() + (double) getOne();
        double valueTwo = store.getTwo() + (double) getTwo();
        return new TwoDoubleVector(value1, valueTwo);
    }

    public TwoDoubleVector remove(TwoDoubleVector store) {
        double value1 = (double) getOne() - store.getOne();
        double value2 = (double) getTwo() - store.getTwo();
        return new TwoDoubleVector(value1, value2);
    }
}
