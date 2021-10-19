package org.core.command.argument.arguments.position;

import org.core.TranslateCore;
import org.core.command.argument.CommandArgument;
import org.core.command.argument.CommandArgumentResult;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;
import org.core.world.WorldExtent;
import org.core.world.position.Positionable;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Gets a world from a single argument, if the source of the command is locatable then this command
 * becomes optional whereby if the string argument is not provided then it will use the world the source is in.
 */
public class WorldArgument implements CommandArgument<WorldExtent> {

    private final String id;

    public WorldArgument(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public CommandArgumentResult<WorldExtent> parse(CommandContext context, CommandArgumentContext<WorldExtent> argument) throws IOException {
        String worldName = context.getCommand()[argument.getFirstArgument()];
        Optional<WorldExtent> opWorld = TranslateCore.getServer().getWorld(worldName, true);
        if (opWorld.isPresent()) {
            return CommandArgumentResult.from(argument, opWorld.get());
        }
        if (context.getSource() instanceof Positionable) {
            WorldExtent world = ((Positionable<?>) context.getSource()).getPosition().getWorld();
            return CommandArgumentResult.from(argument, 0, world);
        }
        throw new IOException("Unknown world name of '" + worldName + "'");
    }

    @Override
    public Set<String> suggest(CommandContext commandContext, CommandArgumentContext<WorldExtent> argument) {
        String worldPeek = commandContext.getCommand()[argument.getFirstArgument()];
        return TranslateCore.getServer().getWorlds().stream().map(WorldExtent::getName).filter(n -> n.toLowerCase().startsWith(worldPeek)).collect(Collectors.toSet());
    }
}
