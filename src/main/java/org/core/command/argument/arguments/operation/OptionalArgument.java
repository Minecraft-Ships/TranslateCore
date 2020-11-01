package org.core.command.argument.arguments.operation;

import org.core.command.argument.arguments.CommandArgument;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class OptionalArgument <T> implements CommandArgument<T> {

    public interface Parser<T>{

        class WrappedParser<T> implements Parser<T> {

            private final T value;

            public WrappedParser(T value){
                this.value = value;
            }

            @Override
            public T parse(CommandContext context, CommandArgumentContext<T> argument) {
                return this.value;
            }
        }

        T parse(CommandContext context, CommandArgumentContext<T> argument);
    }

    private final CommandArgument<T> arg;
    private final Parser<T> value;

    public OptionalArgument(CommandArgument<T> arg, T value){
        this(arg, new Parser.WrappedParser<>(value));
    }

    public OptionalArgument(CommandArgument<T> arg, Parser<T> value){
        this.arg = arg;
        this.value = value;
    }

    public CommandArgument<T> getOriginalArgument(){
        return this.arg;
    }

    @Override
    public String getId() {
        return this.arg.getId();
    }

    @Override
    public Map.Entry<T, Integer> parse(CommandContext context, CommandArgumentContext<T> argument){
        if(context.getCommand().length == argument.getFirstArgument()){
            return new AbstractMap.SimpleImmutableEntry<>(this.value.parse(context, argument), argument.getFirstArgument());
        }
        try{
            return this.arg.parse(context, argument);
        } catch (IOException e) {
            return new AbstractMap.SimpleImmutableEntry<>(this.value.parse(context, argument), argument.getFirstArgument());
        }
    }

    @Override
    public List<String> suggest(CommandContext commandContext, CommandArgumentContext<T> argument) {
        return this.arg.suggest(commandContext, argument);
    }

    @Override
    public String getUsage() {
        String original = this.getOriginalArgument().getUsage();
        return "[" + original.substring(1, original.length() - 1) + "]";
    }
}
