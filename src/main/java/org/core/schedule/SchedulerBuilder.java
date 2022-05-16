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
    default SchedulerBuilder setExecutor(Runnable runnable) {
        this.setRunner((r) -> runnable.run());
        return this;
    }

    @Deprecated
    default Runnable getExecutor() {
        return () -> this.getRunner().accept(null);
    }

    SchedulerBuilder setRunner(Consumer<Scheduler> runner);

    Consumer<Scheduler> getRunner();

    SchedulerBuilder setToRunAfter(Scheduler scheduler);

    Optional<Scheduler> getToRunAfter();

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
