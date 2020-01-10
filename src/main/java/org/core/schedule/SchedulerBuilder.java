package org.core.schedule;

import org.core.platform.Plugin;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public interface SchedulerBuilder {

    Optional<Integer> getDelay();
    SchedulerBuilder setDelay(Integer value);

    Optional<TimeUnit> getDelayUnit();
    SchedulerBuilder setDelayUnit(TimeUnit unit);

    Optional<Integer> getIteration();
    SchedulerBuilder setIteration(Integer value);

    Optional<TimeUnit> getIterationUnit();
    SchedulerBuilder setIterationUnit(TimeUnit unit);

    SchedulerBuilder setExecutor(Runnable runnable);
    Runnable getExecutor();
    SchedulerBuilder setToRunAfter(Scheduler scheduler);
    Optional<Scheduler> getToRunAfter();

    Optional<String> getDisplayName();
    SchedulerBuilder setDisplayName(String displayName);

    Scheduler build(Plugin plugin);

    default SchedulerBuilder useTicksForDelay(){
        return setDelayUnit(null);
    }

    default SchedulerBuilder removeDelay(){
        return setDelay(null);
    }
}
