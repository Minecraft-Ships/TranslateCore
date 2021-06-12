package org.core.command.argument;

import org.core.command.argument.context.CommandContext;
import org.core.entity.living.human.player.LivePlayer;
import org.core.exceptions.NotEnoughArguments;
import org.core.permission.Permission;
import org.core.source.command.CommandSource;

import java.util.List;
import java.util.Optional;

/**
 * An argument command is a command that uses {@link CommandArgument} as its arguments.
 */
public interface ArgumentCommand {

    /**
     * Gets the arguments of the command.
     * This should be a list of arguments that do not change
     *
     * @return A list of command arguments
     */
    List<CommandArgument<?>> getArguments();

    /**
     * Gets a description of the command, designing to inform the user on what the command does.
     *
     * @return A string of the description
     */
    String getDescription();

    /**
     * Gets the permission node of the command that is required to run the command.
     * If a permission is not required then this should return {@link Optional#empty()}
     * <p>
     * When checking to see if this command has permission you should use {@link #hasPermission(CommandSource)}
     *
     * @return The permission to the command
     */
    Optional<Permission> getPermissionNode();

    /**
     * Runs the command
     *
     * @param commandContext The command context for this command
     * @param args           The arguments for the command
     * @return if the command should show the usage (false to show)
     * @throws NotEnoughArguments If the arguments provided are not enough for the command, this will throw
     */
    boolean run(CommandContext commandContext, String... args) throws NotEnoughArguments;

    /**
     * If the command source has permission to run this command
     *
     * @param source The command source to compare
     * @return If the source has permission to run the command
     */
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
