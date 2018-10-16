package org.core.command.simple.argument;

import org.core.command.simple.CommandContext;
import org.core.source.command.CommandSource;

import java.util.List;

public interface CommandArgument <E extends Object> {

    public String getName();
    public E onRun(CommandSource source, CommandContext context);
    public List<String> onTab(CommandSource source, CommandContext context);
}
