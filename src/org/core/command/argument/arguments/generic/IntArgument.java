package org.core.command.argument.arguments.generic;

import org.core.command.argument.ArgumentContext;
import org.core.command.argument.CommandContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IntArgument implements ArgumentContext<Integer> {

    String id;

    public IntArgument(String id){
        this.id = id;
    }

    @Override
    public Integer parse(CommandContext context) throws IOException {
        String argument = context.next();
        try{
            return Integer.parseInt(argument);
        }catch(NumberFormatException e){
            throw new IOException("Not a whole number");
        }
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
