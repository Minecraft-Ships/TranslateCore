package org.core.command.argument.context;

import org.array.utils.ArrayUtils;
import org.core.command.argument.ArgumentCommand;
import org.core.command.argument.arguments.CommandArgument;
import org.core.command.argument.arguments.operation.OptionalArgument;
import org.core.source.command.CommandSource;

import java.io.IOException;
import java.util.*;

public class CommandContext {

    private final String[] commands;
    private final CommandSource source;
    private final Set<ArgumentCommand> potentialCommands = new HashSet<>();

    public CommandContext(CommandSource source, Set<ArgumentCommand> commands, String... command){
        this.commands = command;
        this.potentialCommands.addAll(commands);
        this.source = source;
    }

    public String[] getCommand(){
        return this.commands;
    }

    public CommandSource getSource(){
        return this.source;
    }

    public List<String> getSuggestions(ArgumentCommand command){
        List<CommandArgument<?>> arguments = command.getArguments();
        int commandArgument = 0;
        List<OptionalArgument<?>> optionalArguments = new ArrayList<>();
        for(CommandArgument<?> arg : arguments){
            if(this.commands.length == commandArgument){
                if(arg instanceof OptionalArgument){
                    optionalArguments.add((OptionalArgument<?>)arg);
                    continue;
                }
                return this.suggest(arg, commandArgument);
            }
            if(this.commands.length < commandArgument){
                throw new IllegalArgumentException("Not enough provided arguments for value of that argument");
            }
            try {
                Map.Entry<?, Integer> entry = this.parse(arg, commandArgument);
                if(commandArgument == entry.getValue() && arg instanceof OptionalArgument){
                    optionalArguments.add((OptionalArgument<?>)arg);
                }else{
                    optionalArguments.clear();
                }
                commandArgument = entry.getValue();
            } catch (IOException e) {
                return this.suggest(arg, commandArgument);
            }
        }
        if(optionalArguments.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> ret = new ArrayList<>();
        for(OptionalArgument<?> argument : optionalArguments){
            ret.addAll(suggest(argument, commandArgument));
        }
        return ret;
    }

    public <T> T getArgument(ArgumentCommand command, String id){
        List<CommandArgument<?>> arguments = command.getArguments();
        if(!arguments.stream().anyMatch(a -> a.getId().equals(id))){
            throw new IllegalArgumentException("Argument ID not found within command");
        }
        int commandArgument = 0;
        for(CommandArgument<?> arg : arguments){
            if(this.commands.length == commandArgument && arg instanceof OptionalArgument){
                if(arg.getId().equals(id)){
                    try {
                        return (T)this.parse(arg, commandArgument).getKey();
                    } catch (IOException e) {
                    }
                }
                continue;
            }
            if(this.commands.length < commandArgument){
                throw new IllegalArgumentException("Not enough provided arguments for value of that argument");
            }
            try {
                Map.Entry<?, Integer> entry = this.parse(arg, commandArgument);
                commandArgument = entry.getValue();
                if(arg.getId().equals(id)){
                    return (T)entry.getKey();
                }
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }
        throw new IllegalArgumentException("Argument ID of '" + id + "' not found within command");
    }

    public Set<ErrorContext> getErrors(){
        Set<ErrorContext> map = new HashSet<>();
        for(ArgumentCommand command : this.potentialCommands){
            List<CommandArgument<?>> arguments = command.getArguments();
            int commandArgument = 0;
            for(CommandArgument<?> arg : arguments){
                if(this.commands.length == commandArgument && arg instanceof OptionalArgument){
                    continue;
                }
                if(this.commands.length <= commandArgument){
                    ErrorContext context = new ErrorContext(command, commandArgument, arg, "Not enough arguments");
                    map.add(context);
                    break;
                }
                try {
                    Map.Entry<?, Integer> entry = this.parse(arg, commandArgument);
                    commandArgument = entry.getValue();
                } catch (IOException e) {
                    ErrorContext context = new ErrorContext(command, commandArgument, arg, e.getMessage());
                    map.add(context);
                    break;
                }
            }

        }
        return ArrayUtils.getBests(ErrorContext::getArgumentFailedAt, (b, c) -> b > c, Integer::equals, map);
    }

    public Optional<ArgumentCommand> getCompleteCommand(){
        return this.potentialCommands.stream().filter(command -> {
            List<CommandArgument<?>> arguments = command.getArguments();
            int commandArgument = 0;
            for(CommandArgument<?> arg : arguments){
                if(this.commands.length == commandArgument && arg instanceof OptionalArgument){
                    continue;
                }
                if(this.commands.length <= commandArgument){
                    return false;
                }
                try {
                    Map.Entry<?, Integer> entry = this.parse(arg, commandArgument);
                    commandArgument = entry.getValue();
                } catch (IOException e) {
                    return false;
                }
            }
            return this.commands.length == commandArgument;
        }).findAny();

    }

    public Set<ArgumentCommand> getPotentialCommands(){
        Map<ArgumentCommand, Integer> map = new HashMap<>();
        this.potentialCommands.forEach(c -> {
            List<CommandArgument<?>> arguments = c.getArguments();
            int commandArgument = 0;
            int completeArguments = 0;
            for(int A = 0; A < arguments.size(); A++){
                CommandArgument<?> arg = arguments.get(A);
                if(this.commands.length == commandArgument && arg instanceof OptionalArgument){
                    continue;
                }
                if(this.commands.length <= commandArgument){
                    map.put(c, completeArguments);
                    return;
                }
                try {
                    Map.Entry<?, Integer> entry = this.parse(arg, commandArgument);
                    boolean check = false;
                    if(commandArgument != entry.getValue()){
                        commandArgument = entry.getValue();
                        completeArguments++;
                    }
                } catch (IOException e) {
                    map.put(c, completeArguments);
                    return;
                }
            }
            map.put(c, completeArguments);
        });

        Set<ArgumentCommand> set = new HashSet<>();
        int current = 0;
        for(Map.Entry<ArgumentCommand, Integer> entry : map.entrySet()){
            if(entry.getValue() > current){
                current = entry.getValue();
                set.clear();
            }
            if(entry.getValue() == current){
                set.add(entry.getKey());
            }
        }
        return set;
    }

    private <T> Map.Entry<T, Integer> parse(CommandArgument<T> arg, int commandArgument) throws IOException {
        CommandArgumentContext<T> argContext = new CommandArgumentContext<>(arg, commandArgument, this.commands);
        return arg.parse(this, argContext);
    }

    private <T> List<String> suggest(CommandArgument<T> arg, int commandArgument){
        if(this.commands.length <= commandArgument){
            return Collections.emptyList();
        }
        return arg.suggest(this, new CommandArgumentContext<>(arg, commandArgument, this.commands));
    }
}
