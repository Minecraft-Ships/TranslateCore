package org.core.command;

import org.core.exceptions.NotEnoughArguments;
import org.core.source.command.CommandSource;

import java.util.List;

public interface BaseCommandLauncher {

    String getName();

    default String[] getAliases() {
        return new String[0];
    }

    String getDescription();

    boolean hasPermission(CommandSource source);

    default String getUsage(CommandSource source) {
        return this.getName();
    }

    boolean run(CommandSource source, String... args) throws NotEnoughArguments;

    List<String> tab(CommandSource source, String... args);
}
