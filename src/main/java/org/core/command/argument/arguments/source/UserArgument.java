package org.core.command.argument.arguments.source;

import org.core.CorePlugin;
import org.core.command.argument.arguments.CommandArgument;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;
import org.core.entity.living.human.player.LivePlayer;
import org.core.entity.living.human.player.User;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserArgument implements CommandArgument<User> {

    private final String id;

    public UserArgument(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Map.Entry<User, Integer> parse(CommandContext context, CommandArgumentContext<User> argument) throws IOException {
        String command = context.getCommand()[argument.getFirstArgument()];
        return CorePlugin
                .getServer()
                .getOfflineUser(command)
                .map(user -> new AbstractMap.SimpleEntry<>(user, argument.getFirstArgument() + 1))
                .orElseThrow(() -> new IOException("No user by that name"));
    }

    @Override
    public List<String> suggest(CommandContext commandContext, CommandArgumentContext<User> argument) {
        return CorePlugin.getServer().getOfflineUsers().stream().sorted((o1, o2) -> {
            if (o1 instanceof LivePlayer && o2 instanceof LivePlayer) {
                return 0;
            }
            if (!(o1 instanceof LivePlayer || o2 instanceof LivePlayer)) {
                return 0;
            }
            if (o1 instanceof LivePlayer) {
                return 1;
            }
            return -1;
        })
                .map(User::getName)
                .collect(Collectors.toList());
    }
}
