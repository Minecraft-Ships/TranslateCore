package org.core.utils.lamda.single;

public interface ThrowableConsumer<F, E extends Throwable> {

    void run(F value) throws E;

}