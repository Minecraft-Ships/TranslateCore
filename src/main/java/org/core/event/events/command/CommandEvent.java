package org.core.event.events.command;

import org.core.source.command.CommandSource;
import org.jetbrains.annotations.NotNull;

public interface CommandEvent {

    @NotNull String[] getCommand();

    @NotNull CommandSource getSource();

}
