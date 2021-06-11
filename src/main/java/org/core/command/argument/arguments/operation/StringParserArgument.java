package org.core.command.argument.arguments.operation;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;
import org.core.config.parser.StringParser;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

public class StringParserArgument<P> implements CommandArgument<P> {

    private final String id;
    private final BiFunction<CommandContext, CommandArgumentContext<P>, StringParser<P>> function;
    private final BiFunction<CommandArgumentContext<P>, StringParser<P>, String> failMessage;

    public StringParserArgument(String id, BiFunction<CommandContext, CommandArgumentContext<P>, StringParser<P>> function, BiFunction<CommandArgumentContext<P>, StringParser<P>, String> failMessage){
        this.id = id;
        this.function = function;
        this.failMessage = failMessage;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public CommandArgumentResult<P> parse(CommandContext context, CommandArgumentContext<P> argument) throws IOException {
        StringParser<P> parser = this.function.apply(context, argument);
        String arg = argument.getFocusArgument();
        P value = parser.parse(arg).orElseThrow(() -> new IOException(this.failMessage.apply(argument, parser)));
        return CommandArgumentResult.from(argument, value);
    }

    @Override
    public List<String> suggest(CommandContext commandContext, CommandArgumentContext<P> argument) {
        StringParser<P> parser = this.function.apply(commandContext, argument);
        String peek = argument.getFocusArgument();
        if(!(parser instanceof StringParser.Suggestible)){
            return Collections.emptyList();
        }
        return ((StringParser.Suggestible<P>)parser).getStringSuggestions(peek);
    }
}
