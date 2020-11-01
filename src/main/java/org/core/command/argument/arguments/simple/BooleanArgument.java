package org.core.command.argument.arguments.simple;

import org.core.command.argument.arguments.CommandArgument;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BooleanArgument implements CommandArgument<Boolean> {

    private String id;

    public BooleanArgument(String id){
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Map.Entry<Boolean, Integer> parse(CommandContext context, CommandArgumentContext<Boolean> argument) throws IOException {
        String arg = context.getCommand()[argument.getFirstArgument()];
        if(arg.equals("true")){
            return new AbstractMap.SimpleImmutableEntry<>(true, argument.getFirstArgument() + 1);
        }
        if(arg.equals("false")){
            return new AbstractMap.SimpleImmutableEntry<>(false, argument.getFirstArgument() + 1);
        }
        throw new IOException("'" + arg + "' is not either 'true' or 'false'");
    }

    @Override
    public List<String> suggest(CommandContext commandContext, CommandArgumentContext<Boolean> argument) {
        String peek = commandContext.getCommand()[argument.getFirstArgument()];
        List<String> list = new ArrayList<>();
        if("true".startsWith(peek.toLowerCase())){
            list.add("true");
        }
        if("false".startsWith(peek.toLowerCase())){
            list.add("false");
        }
        return list;
    }
}
