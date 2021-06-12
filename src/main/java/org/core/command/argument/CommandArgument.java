package org.core.command.argument;

/**
 * A argument for {@link ArgumentCommand}. This is designed to parse the target string argument(s) into a single object
 * for ease of use.
 *
 * @param <T> The class type that the command argument will return.
 */
public interface CommandArgument<T> extends ParseCommandArgument<T>, SuggestCommandArgument<T> {

    /**
     * Gets the ID of the command argument.
     * A command argument id needs to be unique within the command, the ID is what separates the arguments.
     * There isn't a standard message structure, however by default the id will be what shows in the usage
     *
     * @return a string Id
     */
    String getId();

    /**
     * Gets the usage of the argument
     *
     * @return a string version of the usage of the argument
     */
    default String getUsage() {
        return "<" + this.getId() + ">";
    }


}
