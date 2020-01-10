package org.core.schedule;

public interface Scheduler {

    void run();
    void cancel();
    Runnable getExecutor();
}
