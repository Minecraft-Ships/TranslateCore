package org.core.command.argument.arguments.simple.number;

import org.core.command.argument.arguments.CommandArgument;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class IntegerArgument implements CommandArgument<Integer> {

    private final String id;

    public IntegerArgument(String id){
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Map.Entry<Integer, Integer> parse(CommandContext context, CommandArgumentContext<Integer> argument) throws IOException {
        try{
            return new AbstractMap.SimpleImmutableEntry<>(Integer.parseInt(context.getCommand()[argument.getFirstArgument()]), argument.getFirstArgument() + 1);
        }catch (NumberFormatException e){
            throw new IOException("'" + context.getCommand()[argument.getFirstArgument()] + "' is not a number");
        }
    }

    @Override
    public List<String> suggest(CommandContext commandContext, CommandArgumentContext<Integer> argument) {
        return Collections.emptyList();
    }
}
