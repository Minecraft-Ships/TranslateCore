package org.core.command.argument.arguments;

public interface CommandArgument<T> extends ParseCommandArgument<T>, SuggestCommandArgument<T> {

    String getId();

    default String getUsage() {
        return "<" + this.getId() + ">";
    }


}
