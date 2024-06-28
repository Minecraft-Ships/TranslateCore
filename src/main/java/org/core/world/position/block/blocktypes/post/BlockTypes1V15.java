package org.core.world.position.block.blocktypes.post;

import org.core.TranslateCore;
import org.core.platform.plugin.details.CorePluginVersion;
import org.core.world.position.block.BlockType;

import java.util.function.Function;

public final class BlockTypes1V15 {
    public static final BlockType BEEHIVE = get("minecraft:beehive");

    public static final BlockType BEE_NEST = get("minecraft:bee_nest");
    public static final BlockType HONEY = get("minecraft:honey_block");

    public static final BlockType HONEYCOMB_BLOCK = get("minecraft:honeycomb_block");

    private BlockTypes1V15() {
        throw new RuntimeException("Do not create");
    }

    private static BlockType get(String idString) {
        return get(version -> idString);
    }

    private static BlockType get(Function<CorePluginVersion, String> id) {
        CorePluginVersion mcVersion = TranslateCore.getPlatform().getMinecraftVersion();
        String idString = id.apply(mcVersion);
        return TranslateCore
                .getPlatform()
                .getBlockType(idString)
                .orElseThrow(() -> new IllegalStateException("Failed to find blocktype '" + idString + "'"));
    }

}
