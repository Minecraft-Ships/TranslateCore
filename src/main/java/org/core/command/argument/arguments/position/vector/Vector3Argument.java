package org.core.command.argument.arguments.position.vector;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;
import org.core.exceptions.NotEnoughArguments;
import org.core.vector.type.Vector3;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Function;

public class Vector3Argument<N extends Number> implements CommandArgument<Vector3<N>> {

    private final String id;
    private final CommandArgument<N>[] numberArgument;
    private final Function<BigDecimal, N> function;

    public Vector3Argument(String id,
                           Function<BigDecimal, N> convert,
                           CommandArgument<N> xArgument,
                           CommandArgument<N> yArgument,
                           CommandArgument<N> zArgument) {
        this.id = id;
        //noinspection unchecked
        this.numberArgument = new CommandArgument[]{xArgument, yArgument, zArgument};
        this.function = convert;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public CommandArgumentResult<Vector3<N>> parse(CommandContext context, CommandArgumentContext<Vector3<N>> argument)
            throws IOException {
        String[] cmd = context.getCommand();
        if (cmd.length < (argument.getFirstArgument() + 3)) {
            throw new IOException("X Y and Z are required");
        }
        BigDecimal[] numbers = new BigDecimal[3];
        for (int index = 0; index < 3; index++) {
            CommandArgumentContext<N> argContext = new CommandArgumentContext<>(this.numberArgument[index],
                                                                                argument.getFirstArgument() + index,
                                                                                cmd);
            N number = this.numberArgument[index].parse(context, argContext).getValue();
            numbers[index] = BigDecimal.valueOf(number.doubleValue());
        }
        Vector3<N> vector3 = new Vector3<>(this.function, numbers[0], numbers[1], numbers[2]);
        return CommandArgumentResult.from(argument, 3, vector3);
    }

    @Override
    public Collection<String> suggest(CommandContext context, CommandArgumentContext<Vector3<N>> argument)
            throws NotEnoughArguments {
        String[] cmd = context.getCommand();
        int min = Math.min(3, cmd.length - argument.getFirstArgument());
        for (int index = 0; index < min; index++) {
            CommandArgumentContext<N> argContext = new CommandArgumentContext<>(this.numberArgument[index],
                                                                                argument.getFirstArgument() + index,
                                                                                cmd);
            try {
                //noinspection ResultOfMethodCallIgnored
                this.numberArgument[index].parse(context, argContext).getValue();
            } catch (IOException e) {
                return this.numberArgument[index].suggest(context, argContext);
            }
        }
        return Collections.emptySet();
    }
}
