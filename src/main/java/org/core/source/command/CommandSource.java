package org.core.source.command;

import org.core.source.Messageable;
import org.core.source.Source;

public interface CommandSource extends Source, Messageable {

    boolean sudo(String wholeCommand);

    default boolean sudo(String... args) {
        return this.sudo(String.join(" ", args));
    }


}
