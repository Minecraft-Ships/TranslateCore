package org.core.world.position.block.blocktypes.post;

import org.core.TranslateCore;
import org.core.platform.plugin.details.CorePluginVersion;
import org.core.world.position.block.BlockType;

import java.util.function.Function;

public final class BlockTypes1V16 {

    public static final BlockType ANCIENT_DEBRIS = get("minecraft:ancient_debris");
    public static final BlockType BASALT = get("minecraft:basalt");
    public static final BlockType BLACKSTONE = get("minecraft:blackstone");
    public static final BlockType NETHERITE_BLOCK = get("minecraft:netherite_block");
    public static final BlockType CHAIN = get("minecraft:chain");
    public static final BlockType CHISELED_NETHERRI = get("minecraft:basalt");

    private BlockTypes1V16() {
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
