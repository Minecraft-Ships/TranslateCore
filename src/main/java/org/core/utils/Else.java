package org.core.utils;

public interface Else {

    interface ThrowableConsumer<F, E extends Throwable> {

        F run() throws E;

    }

    static <F, E extends Throwable> F throwOr(Class<E> clazz, ThrowableConsumer<F, E> consumer, F fail) {
        try {
            return consumer.run();
        } catch (Throwable e) {
            if (clazz.isInstance(e)) {
                return fail;
            }
            throw new RuntimeException(e);
        }
    }
}
