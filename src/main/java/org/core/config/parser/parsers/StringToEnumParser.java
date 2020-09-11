package org.core.config.parser.parsers;

import org.core.config.parser.StringParser;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StringToEnumParser<E extends Enum> implements StringParser.Suggestible<E> {

    private Class<E> clazz;

    public StringToEnumParser(Class<E> clazz){
        this.clazz = clazz;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<E> parse(String original) {
        try {
            E[] values = (E[])clazz.getMethod("values").invoke(null);
            for(E value : values){
                if(value.name().equalsIgnoreCase(original)){
                    return Optional.of(value);
                }
            }
            return Optional.empty();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public String unparse(E value) {
        return value.toString();
    }

    @Override
    public List<E> getSuggestions(String peek) {
        return getSuggestions().stream().filter(e -> e.name().toLowerCase().startsWith(peek.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<E> getSuggestions() {
        try {
            E[] values = (E[])clazz.getMethod("values").invoke(null);
            return Arrays.asList(values);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
