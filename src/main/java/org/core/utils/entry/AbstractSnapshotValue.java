package org.core.utils.entry;

import java.lang.reflect.Type;
import java.util.function.BiConsumer;
import java.util.function.Function;

public abstract class AbstractSnapshotValue<O, V> implements SnapshotValue<O, V>{

    public static abstract class AbstractIdentitySnapshotValue<O, V> extends AbstractSnapshotValue<O, V> implements SnapshotValue.IdentifySnapshotValue<O, V> {

        private final String id;
        private final String name;

        public AbstractIdentitySnapshotValue(String id, String name, V value, Function<O, V> getter, BiConsumer<O, V> setter){
            super(value, getter, setter);
            this.id = id;
            this.name = name;
        }

        @Override
        public String getId() {
            return this.id;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }

    protected V value;
    protected final Function<O, V> getter;
    protected final BiConsumer<O, V> setter;

    public AbstractSnapshotValue(V value, Function<O, V> getter, BiConsumer<O, V> setter){
        this.getter = getter;
        this.setter = setter;
    }

    @Override
    public SnapshotValue<O, V> setValue(V value) {
        this.value = value;
        return this;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public V storeValue(O obj) {
        this.value = this.getter.apply(obj);
        return this.value;
    }

    @Override
    public void applyValue(O obj) {
        this.setter.accept(obj, this.value);
    }

    @Override
    public AbstractSnapshotValue<O, V> clone(){
        throw new IllegalStateException("Clone requires to be implemented");
    }
}
