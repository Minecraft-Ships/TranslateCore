package org.core.config.parser.parsers;

import org.core.config.parser.StringParser;
import org.core.vector.types.Vector3Int;

import java.util.Optional;

public class StringToVector3Int implements StringParser<Vector3Int> {
    @Override
    public Optional<Vector3Int> parse(String original) {
        StringToIntegerParser stip = new StringToIntegerParser();
            String[] split = original.split(",");
            if(split.length != 3){
                return Optional.empty();
            }
            Optional<Integer> opX = stip.parse(split[0]);
            Optional<Integer> opY = stip.parse(split[1]);
            Optional<Integer> opZ = stip.parse(split[2]);
            if(!opX.isPresent() || !opY.isPresent() || !opZ.isPresent()){
                return Optional.empty();
            }
        return Optional.of(new Vector3Int(opX.get(), opY.get(), opZ.get()));
    }

    @Override
    public String unparse(Vector3Int value) {
        return value.getX() + "," + value.getY() + "," + value.getZ();
    }
}
