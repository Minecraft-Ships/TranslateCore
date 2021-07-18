package org.core.command.argument.context;

import org.array.utils.ArrayUtils;
import org.core.command.argument.ArgumentCommand;
import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.arguments.operation.OptionalArgument;
import org.core.source.command.CommandSource;

import java.io.IOException;
import java.util.*;

/**
 * The magic that is the CommandContext. Everything important about the command processing can be found
 * in this class.
 */
public class CommandContext {

    private final String[] commands;
    private final CommandSource source;
    private final Set<ArgumentCommand> potentialCommands = new HashSet<>();

    /**
     * @param source   The command source who is running the command
     * @param commands The potential commands of the command context
     * @param command  The string arguments that the source wrote
     */
    public CommandContext(CommandSource source, Set<ArgumentCommand> commands, String... command) {
        this.commands = command;
        this.potentialCommands.addAll(commands);
        this.source = source;
    }

    /**
     * Gets the raw string arguments that the command source used
     *
     * @return A String array of the raw string arguments
     */
    public String[] getCommand() {
        return this.commands;
    }

    /**
     * The source of the command
     *
     * @return The command sender
     */
    public CommandSource getSource() {
        return this.source;
    }

    /**
     * Gets the suggestions for the next argument in the command.
     * This is based upon the argument command provided as well as the raw
     * string arguments. The suggestion will be to the last of the raw string argument
     *
     * @param command The command to target
     * @return A list of suggestions for the current context and provided command
     */
    public Collection<String> getSuggestions(ArgumentCommand command) {
        List<CommandArgument<?>> arguments = command.getArguments();
        int commandArgument = 0;
        List<OptionalArgument<?>> optionalArguments = new ArrayList<>();
        for (CommandArgument<?> arg : arguments) {
            if (this.commands.length == commandArgument) {
                if (arg instanceof OptionalArgument) {
                    optionalArguments.add((OptionalArgument<?>) arg);
                    continue;
                }
                return this.suggest(arg, commandArgument);
            }
            if (this.commands.length < commandArgument) {
                throw new IllegalArgumentException("Not enough provided arguments for value of that argument");
            }
            try {
                CommandArgumentResult<?> entry = this.parse(arg, commandArgument);
                if (commandArgument == entry.getPosition() && arg instanceof OptionalArgument) {
                    optionalArguments.add((OptionalArgument<?>) arg);
                } else {
                    optionalArguments.clear();
                }
                commandArgument = entry.getPosition();
            } catch (IOException e) {
                return this.suggest(arg, commandArgument);
            }
        }
        if (optionalArguments.isEmpty()) {
            return Collections.emptySet();
        }
        Set<String> ret = new HashSet<>();
        for (OptionalArgument<?> argument : optionalArguments) {
            ret.addAll(suggest(argument, commandArgument));
        }
        return ret;
    }

    /**
     * Gets the argument value of the command argument provided
     *
     * @param command The command to target
     * @param id      The command argument that should be used
     * @param <T>     The expected type of argument (by providing the command argument, the type will be the same unless the argument is breaking the standard)
     * @return The value of the argument
     * @throws IllegalArgumentException If the provided id argument is not part of the command
     * @throws IllegalStateException    Argument requested is asking for string requirements then what is provided
     */
    public <T> T getArgument(ArgumentCommand command, CommandArgument<T> id) {
        return this.getArgument(command, id.getId());
    }

    /**
     * Gets the argument value of the id provided
     *
     * @param command The command to target
     * @param id      The id of the argument to get
     * @param <T>     The expected type of argument
     * @return The value of the argument
     * @throws IllegalArgumentException If the provided id argument is not part of the command
     * @throws IllegalStateException    Argument requested is asking for string requirements then what is provided
     */
    public <T> T getArgument(ArgumentCommand command, String id) {
        List<CommandArgument<?>> arguments = command.getArguments();
        if (arguments.stream().noneMatch(a -> a.getId().equals(id))) {
            throw new IllegalArgumentException("Argument ID not found within command");
        }
        int commandArgument = 0;
        for (CommandArgument<?> arg : arguments) {
            if (this.commands.length == commandArgument && arg instanceof OptionalArgument) {
                if (arg.getId().equals(id)) {
                    try {
                        return (T) this.parse(arg, commandArgument).getValue();
                    } catch (IOException ignored) {
                    }
                }
                continue;
            }
            if (this.commands.length < commandArgument) {
                throw new IllegalStateException("Not enough provided arguments for value of that argument");
            }
            try {
                CommandArgumentResult<?> entry = this.parse(arg, commandArgument);
                commandArgument = entry.getPosition();
                if (arg.getId().equals(id)) {
                    return (T) entry.getValue();
                }
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }
        throw new IllegalArgumentException("Argument ID of '" + id + "' not found within command");
    }

    /**
     * If there is a issue with the command the user is attempting to parse, you can
     * get all the errors with this function. The error is not specific to the command argument
     *
     * @return A set of all errors
     */
    public Set<ErrorContext> getErrors() {
        Set<ErrorContext> map = new HashSet<>();
        for (ArgumentCommand command : this.potentialCommands) {
            List<CommandArgument<?>> arguments = command.getArguments();
            int commandArgument = 0;
            for (CommandArgument<?> arg : arguments) {
                if (this.commands.length == commandArgument && arg instanceof OptionalArgument) {
                    continue;
                }
                if (this.commands.length <= commandArgument) {
                    ErrorContext context = new ErrorContext(command, commandArgument, arg, "Not enough arguments");
                    map.add(context);
                    break;
                }
                try {
                    CommandArgumentResult<?> entry = this.parse(arg, commandArgument);
                    commandArgument = entry.getPosition();
                } catch (IOException e) {
                    ErrorContext context = new ErrorContext(command, commandArgument, arg, e.getMessage());
                    map.add(context);
                    break;
                }
            }

        }
        return ArrayUtils.getBests(ErrorContext::getArgumentFailedAt, (b, c) -> b > c, Integer::equals, map);
    }

    /**
     * Gets the command the user is targeting
     *
     * @return A single argument command, if none can be found then {@link Optional#empty()} will be used
     */
    public Optional<ArgumentCommand> getCompleteCommand() {
        return this.potentialCommands.stream().filter(command -> {
            List<CommandArgument<?>> arguments = command.getArguments();
            int commandArgument = 0;
            for (CommandArgument<?> arg : arguments) {
                if (this.commands.length == commandArgument && arg instanceof OptionalArgument) {
                    continue;
                }
                if (this.commands.length <= commandArgument) {
                    return false;
                }
                try {
                    CommandArgumentResult<?> entry = this.parse(arg, commandArgument);
                    commandArgument = entry.getPosition();
                } catch (IOException e) {
                    return false;
                }
            }
            return this.commands.length == commandArgument;
        }).findAny();

    }

    /**
     * Gets all potential commands from what the user has entered
     *
     * @return A set of all the potential commands
     */
    public Set<ArgumentCommand> getPotentialCommands() {
        Map<ArgumentCommand, Integer> map = new HashMap<>();
        this.potentialCommands.forEach(c -> {
            List<CommandArgument<?>> arguments = c.getArguments();
            int commandArgument = 0;
            int completeArguments = 0;
            for (CommandArgument<?> arg : arguments) {
                if (this.commands.length == commandArgument && arg instanceof OptionalArgument) {
                    continue;
                }
                if (this.commands.length <= commandArgument) {
                    map.put(c, completeArguments);
                    return;
                }
                try {
                    CommandArgumentResult<?> entry = this.parse(arg, commandArgument);
                    boolean check = false;
                    if (commandArgument != entry.getPosition()) {
                        commandArgument = entry.getPosition();
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
        for (Map.Entry<ArgumentCommand, Integer> entry : map.entrySet()) {
            if (entry.getValue() > current) {
                current = entry.getValue();
                set.clear();
            }
            if (entry.getValue() == current) {
                set.add(entry.getKey());
            }
        }
        return set;
    }

    private <T> CommandArgumentResult<T> parse(CommandArgument<T> arg, int commandArgument) throws IOException {
        CommandArgumentContext<T> argContext = new CommandArgumentContext<>(arg, commandArgument, this.commands);
        return arg.parse(this, argContext);
    }

    private <T> Collection<String> suggest(CommandArgument<T> arg, int commandArgument) {
        if (this.commands.length <= commandArgument) {
            return Collections.emptySet();
        }
        return arg.suggest(this, new CommandArgumentContext<>(arg, commandArgument, this.commands));
    }
}
