package org.core.command.argument.arguments.operation;

import org.array.utils.ArrayUtils;
import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ExactArgument implements CommandArgument<String> {

    private final String id;
    private final String[] lookup;
    private final boolean caseSens;

    public ExactArgument(String id) {
        this(id, false, id);
    }

    public ExactArgument(String id, boolean caseSens, String... lookup) {
        if (lookup.length == 0) {
            throw new IllegalArgumentException("Lookup cannot be []");
        }
        this.id = id;
        this.lookup = lookup;
        this.caseSens = caseSens;
    }

    public String[] getLookup() {
        return this.lookup;
    }

    @Override
    public String getId() {
        return this.id;
    }

    private boolean anyMatch(String arg) {
        for (String a : this.lookup) {
            if ((this.caseSens && a.equals(arg)) || (!this.caseSens && a.equalsIgnoreCase(arg))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public CommandArgumentResult<String> parse(CommandContext context, CommandArgumentContext<String> argument) throws IOException {
        String arg = context.getCommand()[argument.getFirstArgument()];
        if (anyMatch(arg)) {
            return CommandArgumentResult.from(argument, arg);
        }
        throw new IOException("Unknown argument of '" + arg + "'");
    }

    @Override
    public Set<String> suggest(CommandContext context, CommandArgumentContext<String> argument) {
        String arg = "";
        if (context.getCommand().length > argument.getFirstArgument()) {
            arg = context.getCommand()[argument.getFirstArgument()];
        }
        Set<String> args = new HashSet<>();
        for (String look : this.lookup) {
            if (look.toLowerCase().startsWith(arg.toLowerCase())) {
                args.add(look);
            }
        }
        return args;
    }

    @Override
    public String getUsage() {
        return "<" + ArrayUtils.toString("/", t -> "\"" + t + "\"", this.lookup) + ">";
    }
}
