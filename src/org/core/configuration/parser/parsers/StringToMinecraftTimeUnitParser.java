package org.core.configuration.parser.parsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class StringToMinecraftTimeUnitParser extends StringToEnumParser<TimeUnit> {

    public StringToMinecraftTimeUnitParser() {
        super(TimeUnit.class);
    }

    @Override
    public Optional<TimeUnit> parse(String original){
        if(original.equalsIgnoreCase("ticks")){
            return null;
        }
        return super.parse(original);
    }

    @Override
    public String unparse(TimeUnit unit){
        if(unit == null){
            return "TICKS";
        }
        return super.unparse(unit);
    }

    @Override
    public List<TimeUnit> getSuggestions(String peek) {
        List<TimeUnit> list = getSuggestions().stream().filter(s -> s != null).filter(s -> s.name().toLowerCase().startsWith(peek.toLowerCase())).collect(Collectors.toList());
        if("ticks".startsWith(peek.toLowerCase())){
            list.add(null);
        }
        return list;
    }

    @Override
    public List<TimeUnit> getSuggestions() {
        List<TimeUnit> list = new ArrayList<>(Arrays.asList(TimeUnit.values()));
        list.add(null);
        return list;
    }
}
