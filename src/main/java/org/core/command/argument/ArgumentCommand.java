package org.core.command.argument;

import org.core.command.argument.arguments.CommandArgument;
import org.core.command.argument.context.CommandContext;
import org.core.entity.living.human.player.LivePlayer;
import org.core.exceptions.NotEnoughArguments;
import org.core.source.command.CommandSource;

import java.util.List;

public interface ArgumentCommand {

    List<CommandArgument<?>> getArguments();
    String getDescription();
    String getPermissionNode();
    boolean run(CommandContext commandContext, String... args) throws NotEnoughArguments;

    default boolean hasPermission(CommandSource source){
        if(source instanceof LivePlayer){
            return ((LivePlayer)source).hasPermission(this.getPermissionNode());
        }
        return true;
    }

}
