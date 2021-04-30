package org.core.command.argument;

import org.core.command.argument.arguments.CommandArgument;
import org.core.command.argument.context.CommandContext;
import org.core.entity.living.human.player.LivePlayer;
import org.core.exceptions.NotEnoughArguments;
import org.core.permission.Permission;
import org.core.source.command.CommandSource;

import java.util.List;
import java.util.Optional;

public interface ArgumentCommand {

    List<CommandArgument<?>> getArguments();

    String getDescription();

    Optional<Permission> getPermissionNode();

    boolean run(CommandContext commandContext, String... args) throws NotEnoughArguments;

    default boolean hasPermission(CommandSource source) {
        Optional<Permission> opNode = this.getPermissionNode();
        if (!opNode.isPresent()) {
            return true;
        }
        if (source instanceof LivePlayer) {
            return ((LivePlayer) source).hasPermission(opNode.get());
        }
        return true;
    }

}
