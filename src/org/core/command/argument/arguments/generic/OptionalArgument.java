package org.core.command.argument.arguments.generic;

import org.core.command.argument.ArgumentContext;
import org.core.command.argument.CommandContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class OptionalArgument<T extends Object> implements ArgumentContext<T> {

    public static class OrElse<T extends Object> extends OptionalArgument<T>{

        protected T elseValue;

        public OrElse(ArgumentContext<T> context, T elseValue) {
            super(context);
        }

        @Override
        public T parse(CommandContext context) throws IOException {
            T value = super.parse(context);
            return value == null ? this.elseValue : value;
        }
    }

    public static class OrArgument<T extends Object> extends OptionalArgument<T>{

        protected ArgumentContext<T> elseArgument;

        public OrArgument(ArgumentContext<T> context, ArgumentContext<T> elseValue) {
            super(context);
        }

        @Override
        public T parse(CommandContext context) throws IOException{
            try {
                return this.context.parse(context);
            }catch (IOException e){
                return this.elseArgument.parse(context);
            }
        }

        @Override
        public List<String> getSuggestions(CommandContext context, String... args){
            List<String> suggestions = super.getSuggestions(context, args);
            List<String> newSuggestions = this.elseArgument.getSuggestions(context, args);
            newSuggestions.addAll(suggestions);
            return suggestions;
        }
    }

    protected ArgumentContext<T> context;

    public OptionalArgument(ArgumentContext<T> context){
        this.context = context;
    }


    @Override
    public T parse(CommandContext context) throws IOException {
        try {
            return this.context.parse(context);
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public List<String> getSuggestions(CommandContext context, String... args) {
        List<ArgumentContext<?>> processors = context.getProcessors();
        ArgumentContext<?> next = null;
        for(int A = 0; A < processors.size(); A++){
            if(processors.get(A).equals(this)){
                if(A == processors.size()){
                    break;
                }
                next = processors.get(A+1);
                break;
            }
        }
        List<String> suggestions = new ArrayList<>(this.context.getSuggestions(context, args));
        if(next != null){
            suggestions.addAll(next.getSuggestions(context, args));
        }
        return suggestions;
    }

    @Override
    public String getId() {
        return this.context.getId();
    }
}
