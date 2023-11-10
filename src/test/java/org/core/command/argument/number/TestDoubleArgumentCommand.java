package org.core.command.argument.number;

import org.core.command.argument.SingleArgumentCommand;
import org.core.command.argument.arguments.simple.number.DoubleArgument;
import org.core.command.argument.context.CommandContext;
import org.core.exceptions.NotEnoughArguments;
import org.core.source.command.ConsoleSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

@ExtendWith(MockitoExtension.class)
public class TestDoubleArgumentCommand {

    @Mock
    ConsoleSource consoleSource;

    @Test
    public void testInvalidIntegerArgument() throws NotEnoughArguments {
        SingleArgumentCommand<Double> command = new SingleArgumentCommand<>(5.4, new DoubleArgument("test"));
        CommandContext context = new CommandContext(this.consoleSource, Collections.singletonList(command), "6");

        // Act
        boolean result = command.run(context, "6");

        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void testNoIntegerArgument() {
        SingleArgumentCommand<Double> command = new SingleArgumentCommand<>(5.5, new DoubleArgument("test"));
        CommandContext context = new CommandContext(this.consoleSource, Collections.singletonList(command));

        // Act
        try {
            command.run(context);

            // Assert
            Assertions.fail("Should have failed. not enough arguments");
        } catch (Exception e) {

        }
    }

    @Test
    public void testValidIntegerArgument() throws NotEnoughArguments {
        SingleArgumentCommand<Double> command = new SingleArgumentCommand<>(5.4, new DoubleArgument("test"));
        CommandContext context = new CommandContext(this.consoleSource, Collections.singletonList(command), "5.4");

        // Act
        boolean result = command.run(context, "5.4");

        // Assert
        Assertions.assertTrue(result);
    }

}
