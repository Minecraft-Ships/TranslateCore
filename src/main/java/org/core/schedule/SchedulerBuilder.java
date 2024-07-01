package org.core.schedule;

import org.core.platform.plugin.Plugin;
import org.core.schedule.unit.TimeUnit;
import org.jetbrains.annotations.NotNull;

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

    Consumer<Scheduler> getRunner();

    SchedulerBuilder setRunner(Consumer<Scheduler> runner);

    Optional<Scheduler> getToRunAfter();

    default SchedulerBuilder setToRunAfter(Scheduler scheduler) {
        return this.setToRunAfter(scheduler, true);
    }

    SchedulerBuilder setToRunAfter(Scheduler scheduler, boolean maintainIfAsync);

    boolean willMaintainScheduleIfAsync();

    Optional<String> getDisplayName();

    SchedulerBuilder setDisplayName(String displayName);

    boolean isAsync();

    SchedulerBuilder setAsync(boolean check);

    @Deprecated
    default Scheduler build(Plugin plugin) {
        if (this.getIteration().isPresent()) {
            return this.buildRepeating(plugin);
        }
        return this.buildDelayed(plugin);
    }

    Scheduler buildDelayed(@NotNull Plugin plugin);

    Scheduler buildRepeating(@NotNull Plugin plugin);

    default SchedulerBuilder useTicksForDelay() {
        return this.setDelayUnit(null);
    }

    default SchedulerBuilder removeDelay() {
        return this.setDelay(null);
    }
}
