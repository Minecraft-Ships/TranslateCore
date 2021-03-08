package org.core.command.argument.arguments.simple.number;

import org.core.command.argument.arguments.CommandArgument;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DoubleArgument implements CommandArgument<Double> {

    private final String id;

    public DoubleArgument(String id){
        this.id = id;
    }
    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Map.Entry<Double, Integer> parse(CommandContext context, CommandArgumentContext<Double> argument) throws IOException {
        return null;
    }

    @Override
    public List<String> suggest(CommandContext commandContext, CommandArgumentContext<Double> argument) {
        return null;
    }
}
