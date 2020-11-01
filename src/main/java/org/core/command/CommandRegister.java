package org.core.command;

import java.util.HashSet;
import java.util.Set;

public class CommandRegister {

    private final Set<CommandLauncher> commands = new HashSet<>();

    public CommandRegister register(CommandLauncher launcher){
        this.commands.add(launcher);
        return this;
    }

    public Set<CommandLauncher> getCommands(){
        return this.commands;
    }


}
