package org.core.command.argument;

import java.io.IOException;
import java.util.List;

public interface ArgumentContext<T extends Object> {

    T parse(CommandContext context) throws IOException;
    List<String> getSuggestions(CommandContext context, String... args);
    String getId();
}
