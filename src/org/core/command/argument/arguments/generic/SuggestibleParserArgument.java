package org.core.command.argument.arguments.generic;

import org.core.command.argument.ArgumentContext;
import org.core.command.argument.CommandContext;
import org.core.configuration.parser.StringParser;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public abstract class SuggestibleParserArgument<T> implements ArgumentContext<T> {

    protected String id;
    protected StringParser.Suggestible<T> parser;

    public SuggestibleParserArgument(String id, StringParser.Suggestible<T> parser){
        this.id = id;
        this.parser = parser;
    }

    protected abstract IOException unableToParse(String next);

    @Override
    public T parse(CommandContext context) throws IOException {
        String next = context.next();
        Optional<T> opValue = this.parser.parse(next);
        if(opValue.isPresent()){
            return opValue.get();
        }
        throw unableToParse(next);
    }

    @Override
    public List<String> getSuggestions(CommandContext context, String... args) {
        if(args.length == 0 || (args.length == 1 && args[0].equalsIgnoreCase(""))){
            return this.parser.getStringSuggestions();
        }else{
            return this.parser.getStringSuggestions(args[0]);
        }
    }

    @Override
    public String getId() {
        return this.id;
    }
}
