package org.core.command;

import org.core.command.argument.ArgumentContext;
import org.core.command.argument.CommandContext;
import org.core.command.argument.arguments.child.ChildrenArgument;
import org.core.exceptions.NotEnoughArguments;
import org.core.source.command.CommandSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public abstract class ChildArgumentCommandLauncher implements BaseCommandLauncher {

    public static abstract class ChildOnly extends ChildArgumentCommandLauncher {

        @Deprecated
        public ChildOnly(ArgumentContext<?>... arguments){
            this(Arrays.asList(arguments));
        }

        @Deprecated
        public ChildOnly(Collection<ArgumentContext<?>> collection){
            this.argumentProcessors.addAll(collection);
        }

        public ChildOnly(ChildrenArgument argument){
            this.argumentProcessors.add(argument);
        }

        @Override
        protected boolean process(CommandContext context){
            return true;
        }

        @Override
        public boolean hasPermission(CommandSource source){
            ChildrenArgument argument = (ChildrenArgument) this.argumentProcessors.get(0);
            return argument.getChildren().values().stream().anyMatch(c -> c.hasPermission(source));
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
    public boolean run(CommandSource source, String... args) throws NotEnoughArguments {
        CommandContext context = new CommandContext(source, this.argumentProcessors, args);
        context.setForTabComplete(false);
        context.validate();
        return process(context);
    }

    @Override
    public List<String> tab(CommandSource source, String... args) {
        CommandContext context = new CommandContext(source, this.argumentProcessors, args);
        return context.suggests();
    }
}
