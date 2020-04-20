package org.core.command.argument.arg.child;

import org.core.command.argument.CommandArgumentLauncher;
import org.core.command.argument.CommandContext;

public class ChildContextEntry extends CommandContext.CommandArgumentEntry<CommandContext.CommandArgumentContext> {

    private CommandArgumentLauncher launcher;

    public ChildContextEntry(ChildArgument entry, int starting, int end, CommandContext.CommandArgumentContext value, CommandArgumentLauncher launcher) {
        super(entry, starting, end, value);
        this.launcher = launcher;
    }

    public CommandArgumentLauncher getLauncher(){
        return this.launcher;
    }

    @Override
    public ChildArgument getArgument(){
        return (ChildArgument) super.getArgument();
    }

}
