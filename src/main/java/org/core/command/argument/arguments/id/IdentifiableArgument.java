package org.core.command.argument.arguments.id;

import org.core.command.argument.arguments.CommandArgument;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;
import org.core.utils.Identifable;

import java.io.IOException;
import java.util.*;

public abstract class IdentifiableArgument<I extends Identifable> implements CommandArgument<I> {

    private final String id;

    public IdentifiableArgument(String id){
        this.id = id;
    }

    public abstract Collection<I> getAll();

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Map.Entry<I, Integer> parse(CommandContext context, CommandArgumentContext<I> argument) throws IOException {
        String id = context.getCommand()[argument.getFirstArgument()];
        Optional<I> opIdent = this.getAll().stream().filter(a -> a.getId().equalsIgnoreCase(id)).findAny();
        if(!opIdent.isPresent()){
            throw new IOException("Invalid ID of '" + id + "'");
        }
        return new AbstractMap.SimpleImmutableEntry<>(opIdent.get(), argument.getFirstArgument() + 1);
    }

    @Override
    public List<String> suggest(CommandContext context, CommandArgumentContext<I> argument) {
        String id = context.getCommand()[argument.getFirstArgument()];
        List<String> suggest = new ArrayList<>();
        this.getAll().stream().filter(a -> a.getId().toLowerCase().startsWith(id.toLowerCase()) || a.getName().toLowerCase().startsWith(id.toLowerCase())).forEach(a -> {
            suggest.add(a.getId());
        });
        return suggest;
    }
}
