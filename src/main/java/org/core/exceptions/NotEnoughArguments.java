package org.core.exceptions;

import java.io.IOException;

public class NotEnoughArguments extends IOException {

    public NotEnoughArguments(Iterable<String> missingArguments) {
        super("Not enough arguments. Missing: " + String.join(",", missingArguments));
    }
}
