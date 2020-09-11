package org.core.schedule.unit;

import java.util.function.Function;

public enum TimeUnit {

    MINECRAFT_TICKS(i -> i),
    SECONDS(i -> i * 20),
    MINUTES(i -> (i * 20) * 100);

    private final Function<Integer, Integer> convert;

    private TimeUnit(Function<Integer, Integer> function){
        this.convert = function;
    }

    public int getTicks(int time){
        return this.convert.apply(time);
    }

}
