package org.core.schedule;

import org.core.platform.plugin.Plugin;

import java.time.LocalTime;
import java.util.Optional;
import java.util.function.Consumer;

public interface Scheduler {

    @Deprecated
    interface Native extends Scheduler {


    }

    Optional<LocalTime> getStartScheduleTime();

    Optional<LocalTime> getStartRunnerTime();

    Optional<LocalTime> getEndTime();

    boolean isAsync();

    String getDisplayName();

    Plugin getPlugin();

    void run();

    Consumer<Scheduler> getRunner();

    void cancel();
}
