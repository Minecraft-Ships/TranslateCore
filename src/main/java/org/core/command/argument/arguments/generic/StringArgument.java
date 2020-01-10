package org.core.command.argument.arguments.generic;

import org.core.command.argument.ArgumentContext;
import org.core.command.argument.CommandContext;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class StringArgument implements ArgumentContext<String> {

    public static class Suggestible extends StringArgument{

        Set<String> suggestions = new HashSet<>();

        public Suggestible(String id, String... suggestions){
            this(id, Arrays.asList(suggestions));
        }

        public Suggestible(String id, Collection<String> suggestions){
            super(id);
            this.suggestions.addAll(suggestions);
        }

        @Override
        public String parse(CommandContext commandContext) throws IOException{
            String next = commandContext.next();
            if(this.suggestions.stream().anyMatch(next::equalsIgnoreCase)){
                return next;
            }
            throw new IOException(next + "is not valid");
        }

        @Override
        public List<String> getSuggestions(CommandContext context, String... args){
            if(args.length == 0 || (args.length == 1 && args[0].equals(""))){
                return new ArrayList<>(this.suggestions);
            }
            return this.suggestions.stream().filter(s -> s.startsWith(args[0])).collect(Collectors.toList());
        }

    }

    protected String id;

    public StringArgument(String id){
        this.id = id;
    }
    @Override
    public String parse(CommandContext context) throws IOException{
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
