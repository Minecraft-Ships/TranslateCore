package org.core.command.argument.context;

import org.core.command.argument.ArgumentCommand;
import org.core.command.argument.arguments.CommandArgument;

public class ErrorContext {

    private ArgumentCommand command;
    private int argumentFailedAt;
    private CommandArgument<?> argument;
    private String error;

    public ErrorContext(ArgumentCommand command, int argumentFailedAt, CommandArgument<?> argument, String error){
        this.command = command;
        this.argumentFailedAt = argumentFailedAt;
        this.argument = argument;
        this.error = error;
    }

    public ArgumentCommand getCommand() {
        return command;
    }

    public int getArgumentFailedAt() {
        return argumentFailedAt;
    }

    public CommandArgument<?> getArgument() {
        return argument;
    }

    public String getError() {
        return error;
    }
}
