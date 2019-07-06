package org.core.command;

import org.core.command.argument.ArgumentContext;
import org.core.command.argument.CommandContext;
import org.core.source.command.CommandSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public abstract class ChildArgumentCommandLauncher implements BaseCommandLauncher {

    public static abstract class ChildOnly extends ChildArgumentCommandLauncher {

        public ChildOnly(ArgumentContext<?>... arguments){
            this(Arrays.asList(arguments));
        }

        public ChildOnly(Collection<ArgumentContext<?>> collection){
            this.argumentProcessors.addAll(collection);
        }

        @Override
        protected boolean process(CommandContext context){
            return true;
        }

    }

    protected List<ArgumentContext<?>> argumentProcessors = new ArrayList<>();

    public ChildArgumentCommandLauncher(ArgumentContext<?>... arguments){
        this(Arrays.asList(arguments));
    }

    public ChildArgumentCommandLauncher(Collection<ArgumentContext<?>> collection){
        this.argumentProcessors.addAll(collection);
    }

    protected abstract boolean process(CommandContext context);

    public List<ArgumentContext<?>> getArgumentProcessors(){
        return this.argumentProcessors;
    }

    @Override
    public boolean run(CommandSource source, String... args) {
        CommandContext context = new CommandContext(source, this.argumentProcessors, args);
        return process(context);
    }

    @Override
    public List<String> tab(CommandSource source, String... args) {
        CommandContext context = new CommandContext(source, this.argumentProcessors, args);
        return context.suggests();
    }
}
