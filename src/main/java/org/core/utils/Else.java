package org.core.utils;

import org.core.utils.lamda.single.ThrowableSupplier;

import java.util.function.Function;

public interface Else {

    static <O, E extends O, F> F canCast(O obj,
                                         Class<E> castTo,
                                         Function<? super E, F> casted,
                                         Function<O, ? extends F> fail) {
        if (castTo.isInstance(obj)) {
            return casted.apply((E) obj);
        }
        return fail.apply(obj);
    }

    static <F, E extends Throwable> F throwOr(Class<E> clazz, ThrowableSupplier<? extends F, E> consumer, F fail) {
        try {
            return consumer.run();
        } catch (Throwable e) {
            if (clazz.isInstance(e)) {
                return fail;
            }
            throw new RuntimeException(e);
        }
    }

    static <F, E extends Throwable> F throwMultiple(Class<E> clazz, ThrowableSupplier<? extends F, E>... attempt)
            throws E {
        E lastThrown = null;
        for (ThrowableSupplier<? extends F, E> current : attempt) {
            try {
                return current.run();
            } catch (Throwable e) {
                if (clazz.isInstance(e)) {
                    lastThrown = (E) e;
                    continue;
                }
                throw new RuntimeException(e);
            }
        }
        if (lastThrown == null) {
            throw new RuntimeException("No exceptions nor values found");
        }
        throw lastThrown;
    }
}
