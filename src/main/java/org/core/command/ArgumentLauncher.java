package org.core.command;

import org.core.CorePlugin;
import org.core.command.argument.ArgumentCommand;
import org.core.command.argument.context.CommandContext;
import org.core.command.argument.context.ErrorContext;
import org.core.exceptions.NotEnoughArguments;
import org.core.source.command.CommandSource;
import org.core.source.viewer.CommandViewer;
import org.core.text.TextColours;

import java.util.*;
import java.util.stream.Collectors;

public interface ArgumentLauncher extends BaseCommandLauncher {

    Set<ArgumentCommand> getCommands();

    @Override
    default boolean run(CommandSource source, String... args) throws NotEnoughArguments{
        CommandContext commandContext = new CommandContext(source, this.getCommands(), args);
        Optional<ArgumentCommand> opCommand = commandContext.getCompleteCommand();
        if(!opCommand.isPresent()){
            if(source instanceof CommandViewer){
                CommandViewer viewer = (CommandViewer)source;
                Set<ErrorContext> errors = commandContext.getErrors();
                if(!errors.isEmpty()){
                    ErrorContext error = errors.iterator().next();
                    viewer.sendMessage(CorePlugin.buildText(TextColours.RED + error.getError()));
                    errors.parallelStream().map(e -> e.getArgument().getUsage()).collect(Collectors.toSet()).forEach(e -> {
                        viewer.sendMessage(CorePlugin.buildText(e));
                    });
                }else{
                    viewer.sendMessage(CorePlugin.buildText(TextColours.RED + "Unknown error"));
                }

                /*viewer.sendMessage(CorePlugin.buildText(TextColours.RED + commandContext.getCompleteError().orElse("Unknown Error")));
                Set<ArgumentCommand> potentialCommands = commandContext.getPotentialCommands();
                potentialCommands.stream().forEach(c -> {
                    viewer.sendMessage(CorePlugin.buildText(TextColours.RED + "/Ships " + ArrayUtils.toString(" ", CommandArgument::getUsage, c.getArguments())));
                });*/
                return true;
            }
            return false;
        }
        if (!opCommand.get().hasPermission(source)){
            if(source instanceof CommandViewer){
                ((CommandViewer)source).sendMessage(CorePlugin.buildText(TextColours.RED + " You do not have permission for that command. You require " + opCommand.get().getPermissionNode()));
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
        List<String> tab = new ArrayList<>();
        commands.forEach(c -> {
            if(!c.hasPermission(source)){
                return;
            }
            tab.addAll(commandContext.getSuggestions(c));
        });
        return tab;
    }
}
