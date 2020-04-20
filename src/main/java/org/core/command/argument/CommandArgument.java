package org.core.command.argument;

import org.core.source.Source;
import org.core.source.command.CommandSource;
import org.core.text.Text;

import java.io.IOException;
import java.util.Set;

public interface CommandArgument<T> {

    interface PermissionArgument<T> extends CommandArgument<T>{

        boolean hasPermission(Source source);

    }

    interface DefaultArgument<T> extends CommandArgument<T> {

        T getDefaultValue();

    }

    Set<String> getSuggestions(CommandSource source, int index, String... words);
    String getId();
    CommandContext.CommandArgumentEntry<T> run(CommandContext context, CommandSource source, int index, String... words) throws IOException;
}
