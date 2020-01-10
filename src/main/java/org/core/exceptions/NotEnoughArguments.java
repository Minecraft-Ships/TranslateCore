package org.core.exceptions;

import org.core.CorePlugin;
import org.core.command.argument.ArgumentContext;

import java.io.IOException;
import java.util.Collection;

public class NotEnoughArguments extends IOException {

    public NotEnoughArguments(Collection<ArgumentContext<?>> missingArguments){
        super("Not enough arguments. Missing: " + CorePlugin.toString(",", a -> a.getId(), missingArguments));
    }
}
