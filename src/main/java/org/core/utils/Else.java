package org.core.utils;

import java.util.function.Function;

public interface Else {

    static <O, E extends O, F> F canCast(O obj, Class<E> castTo, Function<? super E, F> casted,
            Function<O, ? extends F> fail) {
        if (castTo.isInstance(obj)) {
            return casted.apply((E) obj);
        }
        return fail.apply(obj);
    }

    static <F, E extends Throwable> F throwOr(Class<E> clazz, ThrowableConsumer<? extends F, E> consumer, F fail) {
        try {
            return consumer.run();
        } catch (Throwable e) {
            if (clazz.isInstance(e)) {
                return fail;
            }
            throw new RuntimeException(e);
        }
    }

    interface ThrowableConsumer<F, E extends Throwable> {

        F run() throws E;

    }
}
