package org.core.config.parser.parsers;

import org.core.config.parser.StringParser;
import org.core.schedule.unit.TimeUnit;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StringToMinecraftTimeUnitParser implements StringParser.Suggestible<TimeUnit> {

    @Override
    public Optional<TimeUnit> parse(String original){
        for(TimeUnit unit : TimeUnit.values()){
            if(unit.name().equalsIgnoreCase(original)){
                return Optional.of(unit);
            }
        }
        return Optional.empty();
    }

    @Override
    public String unparse(TimeUnit unit){
        return unit.name();
    }

    @Override
    public List<TimeUnit> getSuggestions(String peek) {
        return this.getSuggestions().stream().filter(u -> u.name().startsWith(peek.toUpperCase())).sorted((c1, c2) -> c1.name().compareToIgnoreCase(c2.name())).collect(Collectors.toList());
    }

    @Override
    public List<TimeUnit> getSuggestions() {
        return new ArrayList<>(EnumSet.allOf(TimeUnit.class));
    }
}
