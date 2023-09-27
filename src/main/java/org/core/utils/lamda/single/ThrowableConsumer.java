package org.core.utils.lamda.single;

public interface ThrowableConsumer<F, E extends Throwable> {

    F run() throws E;

}