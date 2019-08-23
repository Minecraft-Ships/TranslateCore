package org.core.configuration.parser.parsers;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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
    public List<TimeUnit> getSuggestions() {
        List<TimeUnit> list = new ArrayList<>(Arrays.asList(TimeUnit.values()));
        list.add(null);
        return list;
    }
}
