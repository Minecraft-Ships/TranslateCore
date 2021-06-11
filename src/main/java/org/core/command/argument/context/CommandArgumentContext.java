package org.core.command.argument.context;

import org.array.utils.ArrayUtils;
import org.core.command.argument.CommandArgument;

public class CommandArgumentContext<T> {

    private final CommandArgument<T> argument;
    private int firstArgument;
    private String[] command;

    public CommandArgumentContext(CommandArgument<T> argument, int firstArgument, String... command) {
        this.argument = argument;
        this.firstArgument = firstArgument;
        this.command = command;
    }

    public CommandArgument<T> getArgument() {
        return this.argument;
    }

    public String[] getRemainingArguments() {
        int last = this.command.length;
        return ArrayUtils.filter(this.firstArgument, last, this.command);
    }

    public String getFocusArgument() {
        return this.command[this.firstArgument];
    }

    public int getFirstArgument() {
        return this.firstArgument;
    }

    public void setCommand(String... args) {
        this.command = args;
    }

    public void setStartArgument(int start) {
        this.firstArgument = start;
    }

}
