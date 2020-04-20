package org.core.command.argument;

import org.core.source.command.CommandSource;

public class CommandArgumentSnapshot {

    private int index;
    private String[] words;
    private CommandSource source;

    public CommandArgumentSnapshot(CommandSource source, int index, String... words) {
        this.index = index;
        this.words = words;
        this.source = source;
    }

    public int getIndex() {
        return index;
    }

    public String[] getWords() {
        return words;
    }

    public CommandSource getSource() {
        return source;
    }
}
