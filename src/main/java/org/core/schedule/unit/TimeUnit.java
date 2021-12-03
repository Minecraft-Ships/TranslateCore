package org.core.schedule.unit;

import java.util.function.Function;

public enum TimeUnit {

    MINECRAFT_TICKS(i -> i, Integer::doubleValue),
    SECONDS(i -> i * 20, i -> i / 20.0),
    MINUTES(i -> (i * 20) * 100, i -> (i / 100.0) / 20);

    private final Function<? super Integer, Integer> convertFrom;
    private final Function<? super Integer, Double> convertTo;


    TimeUnit(Function<? super Integer, Integer> function, Function<? super Integer, Double> from) {
        this.convertFrom = function;
        this.convertTo = from;
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
        return this.fromTicks(time);
    }

    /**
     * Gets the ticks from the provided value
     *
     * @param time the value of time in this TimeUnit
     * @return ticks that result in the same value as your provided value
     */
    public int fromTicks(int time) {
        return this.convertFrom.apply(time);
    }

    /**
     * Gets the time from the provided ticks
     *
     * @param from the value of time in ticks
     * @return time that result in the same value as your provided tick value
     */
    public double toTicks(int from) {
        return this.convertTo.apply(from);
    }

}
