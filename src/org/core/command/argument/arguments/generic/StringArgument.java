package org.core.command.argument.arguments.generic;

import org.core.command.argument.ArgumentContext;
import org.core.command.argument.CommandContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringArgument implements ArgumentContext<String> {

    protected String id;

    public StringArgument(String id){
        this.id = id;
    }
    @Override
    public String parse(CommandContext context) throws IOException {
        return context.next();
    }

    @Override
    public List<String> getSuggestions(CommandContext context, String... args) {
        return new ArrayList<>();
    }

    @Override
    public String getId() {
        return this.id;
    }
}
