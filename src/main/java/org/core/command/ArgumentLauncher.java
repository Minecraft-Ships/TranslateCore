package org.core.command;

import org.core.TranslateCore;
import org.core.adventureText.AText;
import org.core.adventureText.format.NamedTextColours;
import org.core.command.argument.ArgumentCommand;
import org.core.command.argument.context.CommandContext;
import org.core.command.argument.context.ErrorContext;
import org.core.exceptions.NotEnoughArguments;
import org.core.source.command.CommandSource;
import org.core.source.viewer.CommandViewer;
import org.core.text.TextColours;

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
        if (!opCommand.isPresent()) {
            if (source instanceof CommandViewer) {
                CommandViewer viewer = (CommandViewer) source;
                Set<ErrorContext> errors = commandContext.getErrors();
                if (!errors.isEmpty()) {
                    ErrorContext error = errors.iterator().next();
                    viewer.sendMessage(AText.ofPlain(error.getError()).withColour(NamedTextColours.RED));
                    errors
                            .parallelStream()
                            .map(e -> e.getArgument().getUsage())
                            .collect(Collectors.toSet())
                            .forEach(e -> viewer.sendMessage(AText.ofPlain(e).withColour(NamedTextColours.RED)));
                } else {
                    viewer.sendMessage(AText.ofPlain("Unknown error").withColour(NamedTextColours.RED));
                }
                return true;
            }
            return false;
        }
        if (!opCommand.get().hasPermission(source)) {
            if (source instanceof CommandViewer) {
                ((CommandViewer) source).sendMessage(TranslateCore.buildText(TextColours.RED + " You do not have permission for that command. You require " + opCommand.get().getPermissionNode()));
                return true;
            }
            return false;
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
