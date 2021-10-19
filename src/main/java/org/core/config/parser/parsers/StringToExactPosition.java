package org.core.config.parser.parsers;

import org.core.TranslateCore;
import org.core.config.parser.StringParser;
import org.core.world.WorldExtent;
import org.core.world.position.impl.sync.SyncExactPosition;

import java.util.Optional;

public class StringToExactPosition implements StringParser<SyncExactPosition> {

    @Override
    public Optional<SyncExactPosition> parse(String original) {
        try {
            String[] split = original.split(",");
            double x = Double.parseDouble(split[0]);
            double y = Double.parseDouble(split[1]);
            double z = Double.parseDouble(split[2]);
            WorldExtent world = TranslateCore.getServer().getWorldByPlatformSpecific(split[3]).get();
            return Optional.of(world.getPosition(x, y, z));
        }catch (Throwable e) {
            return Optional.empty();
        }
    }

    @Override
    public String unparse(SyncExactPosition value) {
        return value.getX() + "," + value.getY() + "," + value.getZ() + "," + value.getWorld().getPlatformUniqueId();
    }
}
