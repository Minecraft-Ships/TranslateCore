package org.core.command.argument.arguments.source;

import org.core.TranslateCore;
import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;
import org.core.entity.living.human.player.LivePlayer;
import org.core.entity.living.human.player.User;
import org.core.utils.Else;

import java.io.IOException;
import java.util.Objects;
import java.util.Set;
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
    public CommandArgumentResult<User> parse(CommandContext context, CommandArgumentContext<User> argument) throws IOException {
        String command = context.getCommand()[argument.getFirstArgument()];
        try {
            return TranslateCore
                    .getServer()
                    .getOfflineUser(command)
                    .get()
                    .map(user -> CommandArgumentResult.from(argument, user))
                    .orElseThrow(() -> new IOException("No user by that name"));
        } catch (Throwable e) {
            throw new IOException(e);
        }
    }

    @Override
    public Set<String> suggest(CommandContext commandContext, CommandArgumentContext<User> argument) {
        return TranslateCore
                .getServer()
                .getOfflineUsers()
                .stream()
                .map(u -> Else.throwOr(Exception.class, u::get, null))
                .filter(Objects::nonNull)
                .sorted((o1, o2) -> {
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
                .collect(Collectors.toSet());
    }
}
