package org.core.command.argument.string;

import org.core.command.argument.ArgumentCommand;
import org.core.command.argument.SingleArgumentCommand;
import org.core.command.argument.arguments.simple.StringArgument;
import org.core.command.argument.context.CommandContext;
import org.core.exceptions.NotEnoughArguments;
import org.core.source.command.ConsoleSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class TestStringArgumentCommand {

    @Mock
    ConsoleSource consoleSource;

    @Test
    public void testInvalidCommandArgument() throws NotEnoughArguments {
        SingleArgumentCommand<String> command = new SingleArgumentCommand<>("test", new StringArgument("test"));
        CommandContext context = new CommandContext(this.consoleSource, Collections.singletonList(command), "wrong");

        // Act
        boolean result = command.run(context, "wrong");

        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void testMoreArgumentCommandContextArgument() {
        ArgumentCommand command = new SingleArgumentCommand<>("test", new StringArgument("test"));
        CommandContext context = new CommandContext(this.consoleSource, Collections.singletonList(command), "test", "more");

        // Act
        Optional<ArgumentCommand> opCommand = context.getCompleteCommand();

        // Assert
        Assertions.assertFalse(opCommand.isPresent());
    }

    @Test
    public void testMoreArgumentPotentialCommandContextArgument() {
        ArgumentCommand command = new SingleArgumentCommand<>("test", new StringArgument("test"));
        CommandContext context = new CommandContext(this.consoleSource, Collections.singletonList(command), "test", "more");

        // Act
        Set<ArgumentCommand> commands = context.getPotentialCommands();

        // Assert
        Assertions.assertEquals(1, commands.size());
        Assertions.assertEquals(command, commands.iterator().next());
    }

    @Test
    public void testNoArgumentCommandContextArgument() {
        ArgumentCommand command = new SingleArgumentCommand<>("test", new StringArgument("test"));
        CommandContext context = new CommandContext(this.consoleSource, Collections.singletonList(command));

        // Act
        Optional<ArgumentCommand> opCommand = context.getCompleteCommand();

        // Assert
        Assertions.assertFalse(opCommand.isPresent());
    }

    @Test
    public void testNoArgumentPotentialCommandContextArgument() {
        ArgumentCommand command = new SingleArgumentCommand<>("test", new StringArgument("test"));
        CommandContext context = new CommandContext(this.consoleSource, Collections.singletonList(command));

        // Act
        Set<ArgumentCommand> commands = context.getPotentialCommands();

        // Assert
        Assertions.assertEquals(1, commands.size());
        Assertions.assertEquals(command, commands.iterator().next());
    }

    @Test
    public void testValidCommandArgument() throws NotEnoughArguments {
        SingleArgumentCommand<String> command = new SingleArgumentCommand<>("test", new StringArgument("test"));
        CommandContext context = new CommandContext(this.consoleSource, Collections.singletonList(command), "test");

        // Act
        boolean result = command.run(context, "test");

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void testValidCommandContextArgument() {
        ArgumentCommand command = new SingleArgumentCommand<>("test", new StringArgument("test"));
        CommandContext context = new CommandContext(this.consoleSource, Collections.singletonList(command), "test");

        // Act
        Optional<ArgumentCommand> opCommand = context.getCompleteCommand();

        // Assert
        Assertions.assertTrue(opCommand.isPresent());
        Assertions.assertEquals(command, opCommand.get());
    }
}
