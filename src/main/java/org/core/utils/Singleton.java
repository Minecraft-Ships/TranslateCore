package org.core.utils;

import java.util.function.Supplier;

public class Singleton<T> implements Supplier<T> {

    private final Supplier<? extends T> getter;
    private volatile T value;

    public Singleton(Supplier<? extends T> getter) {
        this.getter = getter;
    }


    @Override
    public T get() {
        if (this.value == null) {
            synchronized (this) {
                if (this.value == null) {
                    this.value = this.getter.get();
                }
            }
        }
        return this.value;
    }
}
