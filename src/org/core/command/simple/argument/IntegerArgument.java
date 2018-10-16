package org.core.command.simple.argument;

import org.core.command.simple.CommandContext;
import org.core.source.command.CommandSource;

import java.util.List;
import java.util.Optional;

public class IntegerArgument implements CommandArgument<Integer> {

    protected String name;

    public IntegerArgument(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer onRun(CommandSource source, CommandContext context) {
        Optional<String> opArg = context.getNextArgument();
        if(!opArg.isPresent()){
            return null;
        }
        String arg = opArg.get();
        try{
            return Integer.parseInt(arg);
        }catch(NumberFormatException e) {
            return null;
        }
    }

    @Override
    public List<String> onTab(CommandSource source, CommandContext context) {
        return null;
    }
}
