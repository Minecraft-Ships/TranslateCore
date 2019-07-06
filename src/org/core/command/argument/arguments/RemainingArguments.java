package org.core.command.argument.arguments;

import org.core.command.argument.ArgumentContext;
import org.core.command.argument.CommandContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RemainingArguments<T> implements ArgumentContext<List<T>> {

    protected ArgumentContext<T> context;

    public RemainingArguments(ArgumentContext<T> context){
        this.context = context;
    }

    @Override
    public List<T> parse(CommandContext context) throws IOException {
        List<T> values = new ArrayList<>();
        while(context.hasNext()) {
            this.context.parse(context);
        }
        return values;
    }

    @Override
    public List<String> getSuggestions(CommandContext context, String... args) {
        return this.context.getSuggestions(context, args[args.length - 1]);
    }

    @Override
    public String getId() {
        return this.context.getId();
    }
}
