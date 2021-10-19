package org.core.config.parser.parsers;

import org.core.TranslateCore;
import org.core.config.parser.StringParser;
import org.core.world.WorldExtent;
import org.core.world.position.impl.sync.SyncBlockPosition;

import java.util.Optional;

public class StringToBlockPosition implements StringParser<SyncBlockPosition> {

    @Override
    public Optional<SyncBlockPosition> parse(String original) {
        try {
            String[] split = original.split(",");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            int z = Integer.parseInt(split[2]);
            WorldExtent world = TranslateCore.getServer().getWorldByPlatformSpecific(split[3]).get();
            return Optional.of(world.getPosition(x, y, z));
        }catch (Throwable e) {
            return Optional.empty();
        }
    }

    @Override
    public String unparse(SyncBlockPosition value) {
        return value.getX() + "," + value.getY() + "," + value.getZ() + "," + value.getWorld().getPlatformUniqueId();
    }
}