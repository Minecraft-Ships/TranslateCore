package org.core.schedule.unit;

import java.util.function.Function;

public enum TimeUnit {

    MINECRAFT_TICKS(Double::intValue, Integer::doubleValue),
    SECONDS(i -> (int) (i * 20), i -> i / 20.0),
    MINUTES(i -> (int) ((i * 20.0) * 100), i -> (i / 100.0) / 20);

    private final Function<? super Double, Integer> toTicks;
    private final Function<? super Integer, Double> toUnit;


    TimeUnit(Function<? super Double, Integer> toTicks, Function<? super Integer, Double> toUnit) {
        this.toUnit = toUnit;
        this.toTicks = toTicks;
    }

    /**
     * Gets the ticks from the provided value
     *
     * @param time the value of time in this TimeUnit
     * @return ticks that result in the same value as your provided value
     * @deprecated Use {@link #fromTicks}
     */
    @Deprecated(forRemoval = true)
    public int getTicks(int time) {
        return (int) this.fromTicks(time);
    }

    /**
     * Gets the ticks from the provided value
     *
     * @param ticks the value of time in this TimeUnit
     * @return ticks that result in the same value as your provided value
     */
    public double fromTicks(int ticks) {
        return this.toUnit.apply(ticks);
    }

    /**
     * Gets the time from the provided ticks
     *
     * @param from the value of time in ticks
     * @return time that result in the same value as your provided tick value
     */
    public int toTicks(double from) {
        return this.toTicks.apply(from);
    }

}
