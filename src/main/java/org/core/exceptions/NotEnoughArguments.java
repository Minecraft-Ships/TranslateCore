package org.core.exceptions;

import org.array.utils.ArrayUtils;

import java.io.IOException;
import java.util.Collection;

public class NotEnoughArguments extends IOException {

    public NotEnoughArguments(Collection<String> missingArguments){
        super("Not enough arguments. Missing: " + ArrayUtils.toString(",", a -> a, missingArguments));
    }
}
