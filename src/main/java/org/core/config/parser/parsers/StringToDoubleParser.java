package org.core.config.parser.parsers;

import org.core.config.parser.StringParser;

import java.util.Optional;

public class StringToDoubleParser implements StringParser<Double>{
    @Override
    public Optional<Double> parse(String original) {
        try {
            double parsedDouble = Double.parseDouble(original);
            return Optional.of(parsedDouble);
        } catch (NumberFormatException e) {
            int parsedInt = Integer.parseInt(original);
            return Optional.of((double) parsedInt);
        }
    }

    @Override
    public String unparse(Double value) {
        if(value == null){
            return "" + 0;
        }
        double value2 = value;
        if((int)value2 == value2){
           return "" + ((int)value2);
        }
        return "" + value;
    }

}
