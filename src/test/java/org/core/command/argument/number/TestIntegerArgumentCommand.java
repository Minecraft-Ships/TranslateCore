package org.core.command.argument.number;

import org.core.command.argument.SingleArgumentCommand;
import org.core.command.argument.arguments.simple.number.IntegerArgument;
import org.core.command.argument.context.CommandContext;
import org.core.source.command.ConsoleSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

@ExtendWith(MockitoExtension.class)
public class TestIntegerArgumentCommand {

    @Mock
    ConsoleSource consoleSource;

    @Test
    public void testValidIntegerArgument() {
        SingleArgumentCommand<Integer> command = new SingleArgumentCommand<>(5, new IntegerArgument("test"));
        CommandContext context = new CommandContext(this.consoleSource, Collections.singletonList(command), "5");

        // Act
        boolean result = command.run(context, "5");

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void testInvalidIntegerArgument() {
        SingleArgumentCommand<Integer> command = new SingleArgumentCommand<>(5, new IntegerArgument("test"));
        CommandContext context = new CommandContext(this.consoleSource, Collections.singletonList(command), "6");

        // Act
        boolean result = command.run(context, "6");

        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void testNoIntegerArgument() {
        SingleArgumentCommand<Integer> command = new SingleArgumentCommand<>(5, new IntegerArgument("test"));
        CommandContext context = new CommandContext(this.consoleSource, Collections.singletonList(command));

        // Act
        try {
            command.run(context);

            // Assert
            Assertions.fail("Should have failed. not enough arguments");
        } catch (Exception e) {

        }
    }

}
