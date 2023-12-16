package org.core.world.position.block.blocktypes.post;

import org.core.TranslateCore;
import org.core.platform.plugin.details.CorePluginVersion;
import org.core.world.position.block.BlockType;

import java.util.function.Function;

/**
 * <p>All Minecraft 1.14 blocks</p>
 */
@SuppressWarnings("unused")
public class BlockTypes1V14 extends BlockTypes1V13 {

    public static final BlockType ACACIA_SIGN = get("minecraft:acacia_sign");
    public static final BlockType ACACIA_WALL_SIGN = get("minecraft:acacia_wall_sign");
    public static final BlockType ANDESITE_SLAB = get("minecraft:andesite_slab");
    public static final BlockType ANDESITE_STAIRS = get("minecraft:andesite_stairs");
    public static final BlockType ANDESITE_WALL = get("minecraft:andesite_wall");
    public static final BlockType BAMBOO = get("minecraft:bamboo");
    public static final BlockType BAMBOO_SAPLING = get("minecraft:bamboo_sapling");
    public static final BlockType BARREL = get("minecraft:barrel");
    public static final BlockType BELL = get("minecraft:bell");
    public static final BlockType BIRCH_SIGN = get("minecraft:birch_sign");
    public static final BlockType BIRCH_WALL_SIGN = get("minecraft:birch_wall_sign");
    public static final BlockType BLAST_FURNACE = get("minecraft:blast_furnace");
    public static final BlockType BRICK_WALL = get("minecraft:brick_wall");
    public static final BlockType CAMPFIRE = get("minecraft:campfire");
    public static final BlockType CARTOGRAPHY_TABLE = get("minecraft:cartography_table");
    public static final BlockType COMPOSTER = get("minecraft:composter");
    public static final BlockType CORNFLOWER = get("minecraft:cornflower");
    public static final BlockType CUT_RED_SANDSTONE_SLAB = get("minecraft:cut_red_sandstone_slab");
    public static final BlockType CUT_SANDSTONE_SLAB = get("minecraft:cut_sandstone_slab");
    public static final BlockType DARK_OAK_SIGN = get("minecraft:dark_oak_sign");
    public static final BlockType DARK_OAK_WALL_SIGN = get("minecraft:dark_oak_wall_sign");
    public static final BlockType DIORITE_SLAB = get("minecraft:diorite_slab");
    public static final BlockType DIORITE_STAIRS = get("minecraft:diorite_stairs");
    public static final BlockType DIORITE_WALL = get("minecraft:diorite_wall");
    public static final BlockType END_STONE_BRICK_SLAB = get("minecraft:end_stone_brick_slab");
    public static final BlockType END_STONE_BRICK_STAIRS = get("minecraft:end_stone_brick_stairs");
    public static final BlockType END_STONE_BRICK_WALL = get("minecraft:end_stone_brick_wall");
    public static final BlockType FLETCHING_TABLE = get("minecraft:fletching_table");
    public static final BlockType GRANITE_SLAB = get("minecraft:granite_slab");
    public static final BlockType GRANITE_STAIRS = get("minecraft:granite_stairs");
    public static final BlockType GRANITE_WALL = get("minecraft:granite_wall");
    public static final BlockType GRINDSTONE = get("minecraft:grindstone");
    public static final BlockType JIGSAW = get("minecraft:jigsaw");
    public static final BlockType JUNGLE_SIGN = get("minecraft:jungle_sign");
    public static final BlockType JUNGLE_WALL_SIGN = get("minecraft:jungle_wall_sign");
    public static final BlockType LANTERN = get("minecraft:lantern");
    public static final BlockType LECTERN = get("minecraft:lectern");
    public static final BlockType LILY_OF_THE_VALLEY = get("minecraft:lily_of_the_valley");
    public static final BlockType LOOM = get("minecraft:loom");
    public static final BlockType MOSSY_COBBLESTONE_SLAB = get("minecraft:mossy_cobblestone_slab");
    public static final BlockType MOSSY_COBBLESTONE_STAIRS = get("minecraft:mossy_cobblestone_stairs");
    public static final BlockType MOSSY_STONE_BRICK_SLAB = get("minecraft:mossy_stone_brick_slab");
    public static final BlockType MOSSY_STONE_BRICK_STAIRS = get("minecraft:mossy_stone_brick_stairs");
    public static final BlockType MOSSY_STONE_BRICK_WALL = get("minecraft:mossy_stone_brick_wall");
    public static final BlockType NETHER_BRICK_WALL = get("minecraft:nether_brick_wall");
    public static final BlockType OAK_SIGN = get("minecraft:oak_sign");
    public static final BlockType OAK_WALL_SIGN = get("minecraft:oak_wall_sign");
    public static final BlockType POLISHED_ANDESITE_SLAB = get("minecraft:polished_andesite_slab");
    public static final BlockType POLISHED_ANDESITE_STAIRS = get("minecraft:polished_andesite_stairs");
    public static final BlockType POLISHED_DIORITE_SLAB = get("minecraft:polished_diorite_slab");
    public static final BlockType POLISHED_DIORITE_STAIRS = get("minecraft:polished_diorite_stairs");
    public static final BlockType POLISHED_GRANITE_SLAB = get("minecraft:polished_granite_slab");
    public static final BlockType POLISHED_GRANITE_STAIRS = get("minecraft:polished_granite_stairs");
    public static final BlockType POTTED_BAMBOO = get("minecraft:potted_bamboo");
    public static final BlockType POTTED_CORNFLOWER = get("minecraft:potted_cornflower");
    public static final BlockType POTTED_LILY_OF_THE_VALLEY = get("minecraft:potted_lily_of_the_valley");
    public static final BlockType POTTED_WITHER_ROSE = get("minecraft:potted_wither_rose");
    public static final BlockType PRISMARINE_WALL = get("minecraft:prismarine_wall");
    public static final BlockType RED_NETHER_BRICK_SLAB = get("minecraft:red_nether_brick_slab");
    public static final BlockType RED_NETHER_BRICK_STAIRS = get("minecraft:red_nether_brick_stairs");
    public static final BlockType RED_NETHER_BRICK_WALL = get("minecraft:red_nether_brick_wall");
    public static final BlockType RED_SANDSTONE_WALL = get("minecraft:red_sandstone_wall");
    public static final BlockType SANDSTONE_WALL = get("minecraft:sandstone_wall");
    public static final BlockType SCAFFOLDING = get("minecraft:scaffolding");
    public static final BlockType SMITHING_TABLE = get("minecraft:smithing_table");
    public static final BlockType SMOKER = get("minecraft:smoker");
    public static final BlockType SMOOTH_QUARTZ_SLAB = get("minecraft:smooth_quartz_slab");
    public static final BlockType SMOOTH_QUARTZ_STAIRS = get("minecraft:smooth_quartz_stairs");
    public static final BlockType SMOOTH_RED_SANDSTONE_SLAB = get("minecraft:smooth_red_sandstone_slab");
    public static final BlockType SMOOTH_RED_SANDSTONE_STAIRS = get("minecraft:smooth_red_sandstone_stairs");
    public static final BlockType SMOOTH_SANDSTONE_SLAB = get("minecraft:smooth_sandstone_slab");
    public static final BlockType SMOOTH_SANDSTONE_STAIRS = get("minecraft:smooth_sandstone_stairs");
    public static final BlockType SMOOTH_STONE_SLAB = get("minecraft:smooth_stone_slab");
    public static final BlockType SPRUCE_SIGN = get("minecraft:spruce_sign");
    public static final BlockType SPRUCE_WALL_SIGN = get("minecraft:spruce_wall_sign");
    public static final BlockType STONECUTTER = get("minecraft:stonecutter");
    public static final BlockType STONE_BRICK_WALL = get("minecraft:stone_brick_wall");
    public static final BlockType STONE_STAIRS = get("minecraft:stone_stairs");
    public static final BlockType SWEET_BERRY_BUSH = get("minecraft:sweet_berry_bush");
    public static final BlockType WITHER_ROSE = get("minecraft:wither_rose");

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
