package org.core.command.argument.arguments.source;

import org.core.TranslateCore;
import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;
import org.core.entity.living.human.AbstractHuman;
import org.core.entity.living.human.player.LivePlayer;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class LivePlayerArgument implements CommandArgument<LivePlayer> {

    private final String id;

    public LivePlayerArgument(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public CommandArgumentResult<LivePlayer> parse(CommandContext context, CommandArgumentContext<LivePlayer> argument) throws IOException {
        String command = context.getCommand()[argument.getFirstArgument()];
        Optional<LivePlayer> opPlayer = TranslateCore.getServer()
                .getOnlinePlayers()
                .stream()
                .filter(p -> p.getName().equalsIgnoreCase(command))
                .findFirst();
        if (!opPlayer.isPresent()) {
            throw new IOException("Player is not online");
        }
        return CommandArgumentResult.from(argument, opPlayer.get());

    }

    @Override
    public Set<String> suggest(CommandContext commandContext, CommandArgumentContext<LivePlayer> argument) {
        String command = commandContext.getCommand()[argument.getFirstArgument()];
        return TranslateCore.getServer()
                .getOnlinePlayers()
                .stream()
                .map(AbstractHuman::getName)
                .filter(p -> p.toLowerCase().startsWith(command.toLowerCase()))
                .collect(Collectors.toSet());
    }
}
