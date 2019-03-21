package org.core.command;

import org.core.platform.Plugin;
import org.core.source.command.CommandSource;

import java.util.List;

public interface BaseCommandLauncher {

    String getName();
    String getDescription();
    String getPermission();
    String getUsage(CommandSource source);
    Plugin getPlugin();

    boolean run(CommandSource source, String... args);
    List<String> tab(CommandSource source, String... args);
}
