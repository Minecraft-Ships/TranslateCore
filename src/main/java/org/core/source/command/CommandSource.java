package org.core.source.command;

import org.core.CorePlugin;
import org.core.source.Source;

public interface CommandSource extends Source {

    boolean sudo(String wholeCommand);

    default boolean sudo(String... args){
        return sudo(CorePlugin.toString(" ", args));
    }
}
