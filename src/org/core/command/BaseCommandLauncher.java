package org.core.command;

import org.core.source.command.CommandSource;

import java.util.List;
import java.util.Optional;

public interface BaseCommandLauncher {

    String getName();
    String getDescription();
    Optional<String> getPermission();

    default String getUsage(CommandSource source){
        return getName();
    }

    boolean run(CommandSource source, String... args);
    List<String> tab(CommandSource source, String... args);
}
