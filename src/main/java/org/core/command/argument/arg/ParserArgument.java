package org.core.command.argument.arg;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandContext;
import org.core.configuration.parser.StringParser;
import org.core.source.command.CommandSource;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ParserArgument<T> implements CommandArgument<T> {

    private StringParser<T> parser;
    private String id;

    public ParserArgument(String id, StringParser<T> parser){
        this.parser = parser;
        this.id = id;
    }

    @Override
    public Set<String> getSuggestions(CommandSource source, int index, String... words) {
        if (this.parser instanceof StringParser.Suggestible){
            StringParser.Suggestible<T> suggestible = (StringParser.Suggestible) this.parser;
            if(words.length == 0){
                return new HashSet<>(suggestible.getStringSuggestions());
            }
            List<String> list = suggestible.getStringSuggestions(words[index]);
            return new HashSet<>(list);
        }
        return new HashSet<>();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public CommandContext.CommandArgumentEntry<T> run(CommandContext context, CommandSource source, int index, String... words) throws IOException {
        Optional<T> opValue = this.parser.parse(words[index]);
        if(!opValue.isPresent()){
            throw new IOException("Unable to parse " + words[index]);
        }
        return new CommandContext.CommandArgumentEntry<>(this, index, index + 1, opValue.get());
    }
}
