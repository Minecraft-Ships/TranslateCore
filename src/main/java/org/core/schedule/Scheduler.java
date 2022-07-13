package org.core.schedule;

import org.core.platform.plugin.Plugin;

import java.util.Optional;
import java.util.function.Consumer;

public interface Scheduler {

    interface Threaded extends Scheduler {

        Optional<Thread> getRunning();

    }

    interface Native extends Scheduler {

        void cancel();

    }

    String getDisplayName();

    Plugin getPlugin();

    void run();

    @Deprecated
    void cancel();

    Consumer<Scheduler> getRunner();


    @Deprecated(forRemoval = true)
    default Runnable getExecutor() {
        return () -> this.getRunner().accept(this);
    }
}
