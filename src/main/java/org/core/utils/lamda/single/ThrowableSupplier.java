package org.core.utils.lamda.single;

public interface ThrowableSupplier<F, E extends Throwable> {

    F run() throws E;

}