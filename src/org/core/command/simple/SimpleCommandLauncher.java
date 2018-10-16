package org.core.command.simple;

import org.core.command.BaseCommandLauncher;
import org.core.source.command.CommandSource;

public interface SimpleCommandLauncher extends BaseCommandLauncher {

    boolean run(CommandSource source, CommandContext context);

    @Override
    default boolean run(CommandSource source, String... args){
        return false;
    }
}
