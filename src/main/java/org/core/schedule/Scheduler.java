package org.core.schedule;

import java.util.function.Consumer;

public interface Scheduler {

    void run();

    void cancel();

    Consumer<Scheduler> getRunner();


    @Deprecated
    default Runnable getExecutor() {
        return () -> this.getRunner().accept(this);
    }
}
