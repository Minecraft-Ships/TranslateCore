package org.core.command.argument.arguments.child;

import org.core.command.CommandLauncher;
import org.core.command.argument.ArgumentContext;
import org.core.command.argument.CommandContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChildArgument implements ArgumentContext<Boolean> {

    protected String id;
    protected CommandLauncher launcher;

    public ChildArgument(String id, CommandLauncher launcher){
        this.id = id;
        this.launcher = launcher;
    }

    @Override
    public Boolean parse(CommandContext context) throws IOException {
        List<String> list = new ArrayList<>();
        while(context.hasNext()){
            list.add(context.next());
        }
        return this.launcher.run(context.getSource(), list.toArray(new String[0]));
    }

    @Override
    public List<String> getSuggestions(CommandContext context, String... args) {
        return this.launcher.tab(context.getSource(), args);
    }

    @Override
    public String getId() {
        return this.id;
    }
}
