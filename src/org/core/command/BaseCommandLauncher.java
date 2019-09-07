package org.core.command;

import org.core.exceptions.NotEnoughArguments;
import org.core.source.command.CommandSource;

import java.util.List;

public interface BaseCommandLauncher {

    String getName();
    String getDescription();
    boolean hasPermission(CommandSource source);

    default String getUsage(CommandSource source){
        return getName();
    }

    boolean run(CommandSource source, String... args) throws NotEnoughArguments;
    List<String> tab(CommandSource source, String... args);
}
