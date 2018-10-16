package org.core.command.simple;

public interface SimpleCommandPart {

    String getPermission();
    //arguments
    Runnable getRunnable();
}
