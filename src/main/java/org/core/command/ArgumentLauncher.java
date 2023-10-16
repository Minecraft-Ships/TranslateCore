package org.core.command;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.core.adventureText.AText;
import org.core.adventureText.format.NamedTextColours;
import org.core.command.argument.ArgumentCommand;
import org.core.command.argument.context.CommandContext;
import org.core.command.argument.context.ErrorContext;
import org.core.exceptions.NotEnoughArguments;
import org.core.source.command.CommandSource;
import org.core.source.viewer.CommandViewer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The argument launcher converts a {@link ArgumentCommand} into a registered command.
 */
public interface ArgumentLauncher extends BaseCommandLauncher {

    /**
     * Gets the registered argument commands to this command
     *
     * @return A set of registered Argument Command
     */
    Set<ArgumentCommand> getCommands();

    @Override
    default boolean run(CommandSource source, String... args) throws NotEnoughArguments {
        CommandContext commandContext = new CommandContext(source, this.getCommands(), args);
        Optional<ArgumentCommand> opCommand = commandContext.getCompleteCommand();
        if (opCommand.isEmpty()) {
            Set<ErrorContext> errors = commandContext.getErrors();
            if (errors.isEmpty()) {
                source.sendMessage(Component.text("Unknown error").color(TextColor.color(255, 0, 0)));
                return true;
            }
            ErrorContext error = errors.iterator().next();
            source.sendMessage(Component.text(error.getError()).color(TextColor.color(255, 0, 0)));
            if (errors.size() > 8) {
                return false;
            }
            errors
                    .parallelStream()
                    .map(e -> e.getArgument().getUsage())
                    .collect(Collectors.toSet())
                    .forEach(e -> source.sendMessage(Component.text(e).color(TextColor.color(255, 0, 0))));
            return true;
        }
        if (!opCommand.get().hasPermission(source)) {
            source.sendMessage(AText
                                       .ofPlain("You do not have permission for that command. You require " + opCommand
                                               .get()
                                               .getPermissionNode())
                                       .withColour(NamedTextColours.RED));
            return true;
        }
        return opCommand.get().run(commandContext, args);
    }

    @Override
    default List<String> tab(CommandSource source, String... args) {
        CommandContext commandContext = new CommandContext(source, this.getCommands(), args);
        Set<ArgumentCommand> commands = commandContext.getPotentialCommands();
        TreeSet<String> tab = new TreeSet<>();
        commands.forEach(c -> {
            if (!c.hasPermission(source)) {
                return;
            }
            tab.addAll(commandContext.getSuggestions(c));
        });
        return new ArrayList<>(tab);
    }
}
