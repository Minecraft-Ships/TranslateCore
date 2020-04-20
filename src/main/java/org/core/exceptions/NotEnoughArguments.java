package org.core.exceptions;

import org.core.CorePlugin;

import java.io.IOException;
import java.util.Collection;

public class NotEnoughArguments extends IOException {

    public NotEnoughArguments(Collection<String> missingArguments){
        super("Not enough arguments. Missing: " + CorePlugin.toString(",", a -> a, missingArguments));
    }
}
