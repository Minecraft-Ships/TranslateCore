package org.core.source.command;

import org.array.utils.ArrayUtils;
import org.core.source.Source;

public interface CommandSource extends Source {

    boolean sudo(String wholeCommand);

    default boolean sudo(String... args){
        return sudo(ArrayUtils.toString(" ", t -> t, args));
    }
}
