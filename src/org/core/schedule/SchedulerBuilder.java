package org.core.schedule;

import org.core.platform.Plugin;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public interface SchedulerBuilder {

    public Optional<Integer> getDelay();
    public SchedulerBuilder setDelay(Integer value);

    public Optional<TimeUnit> getDelayUnit();
    public SchedulerBuilder setDelayUnit(TimeUnit unit);

    public SchedulerBuilder setExecutor(Runnable runnable);
    public SchedulerBuilder setToRunAfter(Scheduler scheduler);

    public Scheduler build(Plugin plugin);

    public default SchedulerBuilder useTicksForDelay(){
        return setDelayUnit(null);
    }

    public default SchedulerBuilder removeDelay(){
        return setDelay(null);
    }
}
