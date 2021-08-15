package org.core.collection;

import java.util.Arrays;
import java.util.Collection;

public class AbstractWrappedCollection<T> implements WrappedCollection<T> {

    protected final Collection<T> values;

    public AbstractWrappedCollection(Collection<T> values) {
        this.values = values;
    }

    public AbstractWrappedCollection(T... values) {
        this(Arrays.asList(values));
    }

    @Override
    public boolean equals(Object o) {
        return this.getWrappedCollection().equals(o);
    }

    @Override
    public int hashCode() {
        return this.getWrappedCollection().hashCode();
    }

    @Override
    public Collection<T> getWrappedCollection() {
        return this.values;
    }
}
