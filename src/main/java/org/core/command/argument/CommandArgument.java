package org.core.command.argument;

public interface CommandArgument<T> extends ParseCommandArgument<T>, SuggestCommandArgument<T> {

    String getId();

    default String getUsage() {
        return "<" + this.getId() + ">";
    }


}
