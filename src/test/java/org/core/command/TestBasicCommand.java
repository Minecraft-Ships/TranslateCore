package org.core.command;


import org.core.command.argument.ArgumentCommand;
import org.core.command.argument.CommandArgument;
import org.core.command.argument.context.CommandContext;
import org.core.entity.living.human.player.LivePlayer;
import org.core.exceptions.NotEnoughArguments;
import org.core.permission.Permission;
import org.core.source.command.ConsoleSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TestBasicCommand {

    private static class TestArgumentCommand implements ArgumentCommand {

        private final Permission permission;

        private TestArgumentCommand(Permission permission) {
            this.permission = permission;
        }

        @Override
        public List<CommandArgument<?>> getArguments() {
            return Collections.emptyList();
        }

        @Override
        public String getDescription() {
            return "Test Description";
        }

        @Override
        public Optional<Permission> getPermissionNode() {
            return Optional.of(this.permission);
        }

        @Override
        public boolean run(CommandContext commandContext, String... args) throws NotEnoughArguments {
            return true;
        }
    }

    @Mock
    LivePlayer playerSource;
    @Mock
    ConsoleSource consoleSource;
    @Mock
    Permission permission;

    @Test
    public void testPermissionWithPlayerWithPermission() {
        ArgumentCommand command = new TestArgumentCommand(this.permission);
        Mockito.when(this.playerSource.hasPermission(this.permission)).thenReturn(true);

        // Act
        boolean value = command.hasPermission(this.playerSource);

        //Assert
        Assertions.assertTrue(value);
    }

    @Test
    public void testPermissionWithPlayerWithoutPermission() {
        ArgumentCommand command = new TestArgumentCommand(this.permission);

        // Act
        boolean value = command.hasPermission(this.playerSource);

        //Assert
        Assertions.assertFalse(value);
    }

    @Test
    public void testPermissionWithConsole() {
        ArgumentCommand command = new TestArgumentCommand(this.permission);

        // Act
        boolean value = command.hasPermission(this.consoleSource);

        //Assert
        Assertions.assertTrue(value);
    }


}
