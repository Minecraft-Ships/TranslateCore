package org.core.configuration.parser.parsers;

import org.core.CorePlugin;
import org.core.configuration.parser.StringParser;
import org.core.world.WorldExtent;
import org.core.world.position.BlockPosition;

import java.util.Optional;

public class StringToBlockPosition implements StringParser<BlockPosition> {

    @Override
    public Optional<BlockPosition> parse(String original) {
        try {
            String[] split = original.split(",");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            int z = Integer.parseInt(split[2]);
            WorldExtent world = CorePlugin.getServer().getWorldByPlatformSpecific(split[3]).get();
            return Optional.of(world.getPosition(x, y, z));
        }catch (Throwable e) {
            return Optional.empty();
        }
    }

    @Override
    public String unparse(BlockPosition value) {
        return value.getX() + "," + value.getY() + "," + value.getZ() + "," + value.getWorld().getPlatformUniquieId();
    }
}