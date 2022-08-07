package org.core.schedule;

import org.core.platform.plugin.Plugin;
import org.core.schedule.unit.TimeUnit;

import java.util.Optional;
import java.util.function.Consumer;

public interface SchedulerBuilder {

    Optional<Integer> getDelay();

    SchedulerBuilder setDelay(Integer value);

    Optional<TimeUnit> getDelayUnit();

    SchedulerBuilder setDelayUnit(TimeUnit unit);

    Optional<Integer> getIteration();

    SchedulerBuilder setIteration(Integer value);

    Optional<TimeUnit> getIterationUnit();

    SchedulerBuilder setIterationUnit(TimeUnit unit);

    @Deprecated
    default Runnable getExecutor() {
        return () -> this.getRunner().accept(null);
    }

    @Deprecated
    default SchedulerBuilder setExecutor(Runnable runnable) {
        this.setRunner((r) -> runnable.run());
        return this;
    }

    Consumer<Scheduler> getRunner();

    SchedulerBuilder setRunner(Consumer<Scheduler> runner);

    Optional<Scheduler> getToRunAfter();

    SchedulerBuilder setToRunAfter(Scheduler scheduler);

    Optional<String> getDisplayName();

    SchedulerBuilder setDisplayName(String displayName);

    boolean isAsync();

    SchedulerBuilder setAsync(boolean check);

    Scheduler build(Plugin plugin);

    default SchedulerBuilder useTicksForDelay() {
        return this.setDelayUnit(null);
    }

    default SchedulerBuilder removeDelay() {
        return this.setDelay(null);
    }
}
