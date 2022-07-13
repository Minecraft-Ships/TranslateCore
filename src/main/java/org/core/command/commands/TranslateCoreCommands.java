package org.core.command.commands;

import org.core.command.ArgumentLauncher;
import org.core.command.argument.ArgumentCommand;
import org.core.source.command.CommandSource;
import org.core.source.command.ConsoleSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TranslateCoreCommands implements ArgumentLauncher {

    private final Set<ArgumentCommand> commands = new HashSet<>();

    public TranslateCoreCommands(ArgumentCommand... commands) {
        this.commands.addAll(Arrays.asList(commands));
    }

    @Override
    public Set<ArgumentCommand> getCommands() {
        return this.commands;
    }

    @Override
    public String getName() {
        return "TranslateCore";
    }

    @Override
    public String getDescription() {
        return "All TranslateCore commands";
    }

    @Override
    public boolean hasPermission(CommandSource source) {
        return source instanceof ConsoleSource;
    }
}
