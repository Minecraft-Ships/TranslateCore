package org.core.config.parser.parsers;

import org.core.config.parser.StringParser;
import org.core.utils.time.TimeRange;

import java.time.LocalTime;
import java.util.Optional;

public class StringToTimeRangeParser implements StringParser<TimeRange> {

    @Override
    public Optional<TimeRange> parse(String original) {
        String[] split = original.split("-");
        if (split.length != 2) {
            return Optional.empty();
        }
        String timeStr = split[0];
        String ticksStr = split[1];
        try {
            LocalTime time = LocalTime.parse(timeStr);
            int ticks = Integer.parseInt(ticksStr);
            return Optional.of(new TimeRange(time, ticks));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    @Override
    public String unparse(TimeRange value) {
        return value.getTime().toString() + "-" + value.getTicks();
    }
}
