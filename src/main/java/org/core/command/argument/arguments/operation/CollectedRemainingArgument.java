package org.core.command.argument.arguments.operation;

import org.core.command.argument.arguments.CommandArgument;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;

import java.io.IOException;
import java.util.*;

public class CollectedRemainingArgument<T, C extends Collection<T>> implements CommandArgument<List<T>> {

    private final String id;
    private final List<CommandArgument<C>> argument;

    @SafeVarargs
    public CollectedRemainingArgument(String id, CommandArgument<C>... argument){
        this(id, Arrays.asList(argument));
    }

    public CollectedRemainingArgument(String id, Collection<CommandArgument<C>> argument){
        if(argument.isEmpty()){
            throw new IllegalArgumentException("Remaining Argument cannot have a argument of empty");
        }
        this.id = id;
        this.argument = new ArrayList<>(argument);
    }

    private Map.Entry<C, Integer> parseAny(CommandContext context, int B) throws IOException{
        IOException e1 = null;
        for(int A = 0; A < this.argument.size(); A++){
            try {
                CommandArgumentContext<C> argumentContext = new CommandArgumentContext<>(this.argument.get(A), B, context.getCommand());
                return this.argument.get(A).parse(context, argumentContext);
            } catch (IOException e) {
                if(A == 0){
                    e1 = e;
                }
            }
        }
        if(e1 == null){
            //shouldnt be possible
            throw new IOException("Unknown error occurred");
        }
        throw e1;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Map.Entry<List<T>, Integer> parse(CommandContext context, CommandArgumentContext<List<T>> argument) throws IOException {
        int A = argument.getFirstArgument();
        List<T> list = new ArrayList<>();
        while(A < context.getCommand().length){
            Map.Entry<C, Integer> entry = parseAny(context, A);
            A = entry.getValue();
            list.addAll(entry.getKey());
        }
        return new AbstractMap.SimpleImmutableEntry<>(list, A);
    }

    @Override
    public List<String> suggest(CommandContext context, CommandArgumentContext<List<T>> argument) {
        int A = argument.getFirstArgument();
        while(A < context.getCommand().length){
            Map.Entry<C, Integer> entry;
            try {
                entry = parseAny(context, A);
            } catch (IOException e) {
                List<String> list = new ArrayList<>();
                for(CommandArgument<C> arg : this.argument){
                    CommandArgumentContext<C> argumentContext = new CommandArgumentContext<>(arg, A, context.getCommand());
                    list.addAll(arg.suggest(context, argumentContext));
                }
                return list;
            }
            A = entry.getValue();
        }
        return Collections.emptyList();
    }
}
