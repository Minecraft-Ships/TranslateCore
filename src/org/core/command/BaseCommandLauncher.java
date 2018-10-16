package org.core.command;

import org.core.source.command.CommandSource;

public interface BaseCommandLauncher {

    String getName();
    String getDescription();
    String getPermission();
    String getUsage(CommandSource source);

    boolean run(CommandSource source, String... args);
}
