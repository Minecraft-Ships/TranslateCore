package org.core.stores.number;

import org.core.stores.ThreeStore;

public class TripleNumberStore<A extends Object> extends ThreeStore<A, A, A> {

    public TripleNumberStore(A value1, A value2, A value3) {
        super(value1, value2, value3);
    }

}
