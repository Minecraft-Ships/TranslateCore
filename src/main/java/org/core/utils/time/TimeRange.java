package org.core.utils.time;

import org.core.schedule.unit.TimeUnit;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TimeRange {

    private final LocalTime time;
    private final int ticks;

    public TimeRange(int ticks) {
        this(LocalTime.now(), ticks);
    }

    public TimeRange(int duration, TimeUnit convert){
        this(convert.fromTicks(duration));
    }

    public TimeRange(LocalTime time, int ticks) {
        this.time = time;
        this.ticks = ticks;
    }

    public LocalTime getTime() {
        return time;
    }

    public int getTicks() {
        return ticks;
    }

    public LocalTime getEndTime() {
        int milliseconds = this.ticks * 50;
        return this.time.plus(milliseconds, ChronoUnit.MILLIS);
    }
}
