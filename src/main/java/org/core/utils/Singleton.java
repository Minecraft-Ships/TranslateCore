package org.core.utils;

import java.util.function.Supplier;

public class Singleton<T> implements Supplier<T> {

    private final Supplier<T> getter;
    private T value;

    public Singleton(Supplier<T> getter){
        this.getter = getter;
    }


    @Override
    public T get() {
        if(this.value == null){
            synchronized (this) {
                if (this.value == null) {
                    this.value = this.getter.get();
                }
            }
        }
        return this.value;
    }
}
