package org.core.command.simple;

import org.core.command.simple.argument.CommandArgument;

import java.util.*;

public class CommandContext {

    protected List<CommandArgument<? extends Object>> commands = new ArrayList<>();
    protected Map<CommandArgument<? extends Object>, ? extends Object> used = new HashMap<>();
    protected String[] rawCommand;
    protected int nextArgument;

    public List<CommandArgument<? extends Object>> getCommand() {
        return this.commands;
    }

    public Map<CommandArgument<? extends Object>, ? extends Object> usedCommands(){
        return this.used;
    }

    public String[] getRawCommand(){
        return this.rawCommand;
    }

    public int getNextRawArgument(){
        return this.nextArgument;
    }

    public Optional<String> getNextArgument(){
        String[] args = getRawCommand();
        int nextArg = getNextRawArgument();
        if(args.length <= nextArg){
            return Optional.empty();
        }
        return Optional.of(args[nextArg]);
    }


}
