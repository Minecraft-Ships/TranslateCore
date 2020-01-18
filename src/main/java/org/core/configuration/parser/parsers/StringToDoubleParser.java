package org.core.configuration.parser.parsers;

import org.core.configuration.ConfigurationFile;
import org.core.configuration.ConfigurationNode;
import org.core.configuration.parser.StringParser;

import java.util.Optional;

public class StringToDoubleParser implements StringParser<Double>, StringParser.SpecialParser<Double> {
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

    @Override
    public Optional<Double> get(ConfigurationFile file, ConfigurationNode node) {
        return file.parseDouble(node);
    }
}
