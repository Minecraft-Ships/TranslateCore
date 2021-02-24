package org.core.command.argument.arguments.position;

import org.core.CorePlugin;
import org.core.command.argument.arguments.CommandArgument;
import org.core.command.argument.context.CommandArgumentContext;
import org.core.command.argument.context.CommandContext;
import org.core.world.WorldExtent;
import org.core.world.position.Positionable;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class WorldArgument implements CommandArgument<WorldExtent> {

    private final String id;

    public WorldArgument(String id){
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Map.Entry<WorldExtent, Integer> parse(CommandContext context, CommandArgumentContext<WorldExtent> argument) throws IOException {
        String worldName = context.getCommand()[argument.getFirstArgument()];
        Optional<WorldExtent> opWorld = CorePlugin.getServer().getWorld(worldName, true);
        if(opWorld.isPresent()) {
            return new AbstractMap.SimpleImmutableEntry<>(opWorld.get(), argument.getFirstArgument());
        }
        if(context.getSource() instanceof Positionable){
            WorldExtent world = ((Positionable<?>) context.getSource()).getPosition().getWorld();
            return new AbstractMap.SimpleImmutableEntry<>(world, argument.getFirstArgument());
        }
        throw new IOException("Unknown world name of '" + worldName + "'");
    }

    @Override
    public List<String> suggest(CommandContext commandContext, CommandArgumentContext<WorldExtent> argument) {
        String worldPeek = commandContext.getCommand()[argument.getFirstArgument()];
        return CorePlugin.getServer().getWorlds().stream().map(WorldExtent::getName).filter(n -> n.toLowerCase().startsWith(worldPeek)).collect(Collectors.toList());
    }
}
