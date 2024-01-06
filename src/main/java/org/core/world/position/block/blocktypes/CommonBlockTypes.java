package org.core.world.position.block.blocktypes;

import org.core.TranslateCore;
import org.core.platform.plugin.details.CorePluginVersion;
import org.core.world.position.block.BlockType;

import java.util.function.Function;

/**
 * <p>All Blocks found between legacy blocks and after Minecraft 1.13</p>
 */
@SuppressWarnings({"unused", "HardCodedStringLiteral", "DuplicateStringLiteralInspection"})
public class CommonBlockTypes {

    public static final BlockType ACACIA_DOOR = get("minecraft:acacia_door");
    public static final BlockType ACACIA_FENCE = get("minecraft:acacia_fence");
    public static final BlockType ACACIA_FENCE_GATE = get("minecraft:acacia_fence_gate");
    public static final BlockType ACACIA_STAIRS = get("minecraft:acacia_stairs");
    public static final BlockType ACTIVATOR_RAIL = get("minecraft:activator_rail");
    public static final BlockType AIR = get("minecraft:air");
    public static final BlockType ANVIL = get("minecraft:anvil");
    public static final BlockType BARRIER = get("minecraft:barrier");
    public static final BlockType BEACON = get("minecraft:beacon");
    public static final BlockType BEDROCK = get("minecraft:bedrock");
    public static final BlockType BEETROOTS = get("minecraft:beetroots");
    public static final BlockType BIRCH_DOOR = get("minecraft:birch_door");
    public static final BlockType BIRCH_FENCE = get("minecraft:birch_fence");
    public static final BlockType BIRCH_FENCE_GATE = get("minecraft:birch_fence_gate");
    public static final BlockType BIRCH_STAIRS = get("minecraft:birch_stairs");
    public static final BlockType BLACK_GLAZED_TERRACOTTA = get("minecraft:black_glazed_terracotta");
    public static final BlockType BLACK_SHULKER_BOX = get("minecraft:black_shulker_box");
    public static final BlockType BLUE_GLAZED_TERRACOTTA = get("minecraft:blue_glazed_terracotta");
    public static final BlockType BLUE_SHULKER_BOX = get("minecraft:blue_shulker_box");
    public static final BlockType BONE_BLOCK = get("minecraft:bone_block");
    public static final BlockType BOOKSHELF = get("minecraft:bookshelf");
    public static final BlockType BREWING_STAND = get("minecraft:brewing_stand");
    public static final BlockType BRICKS = get("minecraft:bricks");
    public static final BlockType BRICK_STAIRS = get("minecraft:brick_stairs");
    public static final BlockType BROWN_GLAZED_TERRACOTTA = get("minecraft:brown_glazed_terracotta");
    public static final BlockType BROWN_MUSHROOM = get("minecraft:brown_mushroom");
    public static final BlockType BROWN_MUSHROOM_BLOCK = get("minecraft:brown_mushroom_block");
    public static final BlockType BROWN_SHULKER_BOX = get("minecraft:brown_shulker_box");
    public static final BlockType CACTUS = get("minecraft:cactus");
    public static final BlockType CAKE = get("minecraft:cake");
    public static final BlockType CARROTS = get("minecraft:carrots");
    public static final BlockType CAULDRON = get("minecraft:cauldron");
    public static final BlockType CHAIN_COMMAND_BLOCK = get("minecraft:chain_command_block");
    public static final BlockType CHEST = get("minecraft:chest");
    public static final BlockType CHORUS_FLOWER = get("minecraft:chorus_flower");
    public static final BlockType CHORUS_PLANT = get("minecraft:chorus_plant");
    public static final BlockType CLAY = get("minecraft:clay");
    public static final BlockType COAL_BLOCK = get("minecraft:coal_block");
    public static final BlockType COAL_ORE = get("minecraft:coal_ore");
    public static final BlockType COBBLESTONE = get("minecraft:cobblestone");
    public static final BlockType COBBLESTONE_WALL = get("minecraft:cobblestone_wall");
    public static final BlockType COCOA = get("minecraft:cocoa");
    public static final BlockType COMMAND_BLOCK = get("minecraft:command_block");
    public static final BlockType CRAFTING_TABLE = get("minecraft:crafting_table");
    public static final BlockType CYAN_GLAZED_TERRACOTTA = get("minecraft:cyan_glazed_terracotta");
    public static final BlockType CYAN_SHULKER_BOX = get("minecraft:cyan_shulker_box");
    public static final BlockType DARK_OAK_DOOR = get("minecraft:dark_oak_door");
    public static final BlockType DARK_OAK_FENCE = get("minecraft:dark_oak_fence");
    public static final BlockType DARK_OAK_FENCE_GATE = get("minecraft:dark_oak_fence_gate");
    public static final BlockType DARK_OAK_STAIRS = get("minecraft:dark_oak_stairs");
    public static final BlockType DAYLIGHT_DETECTOR = get("minecraft:daylight_detector");
    public static final BlockType DETECTOR_RAIL = get("minecraft:detector_rail");
    public static final BlockType DIAMOND_BLOCK = get("minecraft:diamond_block");
    public static final BlockType DIAMOND_ORE = get("minecraft:diamond_ore");
    public static final BlockType DIRT = get("minecraft:dirt");
    public static final BlockType DISPENSER = get("minecraft:dispenser");
    public static final BlockType DRAGON_EGG = get("minecraft:dragon_egg");
    public static final BlockType DROPPER = get("minecraft:dropper");
    public static final BlockType EMERALD_BLOCK = get("minecraft:emerald_block");
    public static final BlockType EMERALD_ORE = get("minecraft:emerald_ore");
    public static final BlockType ENCHANTING_TABLE = get("minecraft:enchanting_table");
    public static final BlockType ENDER_CHEST = get("minecraft:ender_chest");
    public static final BlockType END_GATEWAY = get("minecraft:end_gateway");
    public static final BlockType END_PORTAL = get("minecraft:end_portal");
    public static final BlockType END_PORTAL_FRAME = get("minecraft:end_portal_frame");
    public static final BlockType END_ROD = get("minecraft:end_rod");
    public static final BlockType END_STONE = get("minecraft:end_stone");
    public static final BlockType FARMLAND = get("minecraft:farmland");
    public static final BlockType FIRE = get("minecraft:fire");
    public static final BlockType FLOWER_POT = get("minecraft:flower_pot");
    public static final BlockType FROSTED_ICE = get("minecraft:frosted_ice");
    public static final BlockType FURNACE = get("minecraft:furnace");
    public static final BlockType GLASS = get("minecraft:glass");
    public static final BlockType GLASS_PANE = get("minecraft:glass_pane");
    public static final BlockType GLOWSTONE = get("minecraft:glowstone");
    public static final BlockType GOLD_BLOCK = get("minecraft:gold_block");
    public static final BlockType GOLD_ORE = get("minecraft:gold_ore");
    public static final BlockType GRASS = get(version -> version.getMajor() == 1 && version.getMinor() >= 20
            && version.getPatch() >= 3 ? "minecraft:short_grass" : "minecraft:grass");
    public static final BlockType GRASS_PATH = get(version -> version.getMajor() == 1
            && version.getMinor() == 16 ? "minecraft:grass_path" : "minecraft:dirt_path");
    public static final BlockType GRAVEL = get("minecraft:gravel");
    public static final BlockType GRAY_GLAZED_TERRACOTTA = get("minecraft:gray_glazed_terracotta");
    public static final BlockType GRAY_SHULKER_BOX = get("minecraft:gray_shulker_box");
    public static final BlockType GREEN_GLAZED_TERRACOTTA = get("minecraft:green_glazed_terracotta");
    public static final BlockType GREEN_SHULKER_BOX = get("minecraft:green_shulker_box");
    public static final BlockType HAY_BLOCK = get("minecraft:hay_block");
    public static final BlockType HEAVY_WEIGHTED_PRESSURE_PLATE = get("minecraft:heavy_weighted_pressure_plate");
    public static final BlockType HOPPER = get("minecraft:hopper");
    public static final BlockType ICE = get("minecraft:ice");
    public static final BlockType IRON_BARS = get("minecraft:iron_bars");
    public static final BlockType IRON_BLOCK = get("minecraft:iron_block");
    public static final BlockType IRON_DOOR = get("minecraft:iron_door");
    public static final BlockType IRON_ORE = get("minecraft:iron_ore");
    public static final BlockType IRON_TRAPDOOR = get("minecraft:iron_trapdoor");
    public static final BlockType JUKEBOX = get("minecraft:jukebox");
    public static final BlockType JUNGLE_DOOR = get("minecraft:jungle_door");
    public static final BlockType JUNGLE_FENCE = get("minecraft:jungle_fence");
    public static final BlockType JUNGLE_FENCE_GATE = get("minecraft:jungle_fence_gate");
    public static final BlockType JUNGLE_STAIRS = get("minecraft:jungle_stairs");
    public static final BlockType LADDER = get("minecraft:ladder");
    public static final BlockType LAPIS_BLOCK = get("minecraft:lapis_block");
    public static final BlockType LAPIS_ORE = get("minecraft:lapis_ore");
    public static final BlockType LAVA = get("minecraft:lava");
    public static final BlockType LEVER = get("minecraft:lever");
    public static final BlockType LIGHT_BLUE_GLAZED_TERRACOTTA = get("minecraft:light_blue_glazed_terracotta");
    public static final BlockType LIGHT_BLUE_SHULKER_BOX = get("minecraft:light_blue_shulker_box");
    public static final BlockType LIGHT_WEIGHTED_PRESSURE_PLATE = get("minecraft:light_weighted_pressure_plate");
    public static final BlockType LIME_GLAZED_TERRACOTTA = get("minecraft:lime_glazed_terracotta");
    public static final BlockType LIME_SHULKER_BOX = get("minecraft:lime_shulker_box");
    public static final BlockType MAGENTA_GLAZED_TERRACOTTA = get("minecraft:magenta_glazed_terracotta");
    public static final BlockType MAGENTA_SHULKER_BOX = get("minecraft:magenta_shulker_box");
    public static final BlockType MELON_STEM = get("minecraft:melon_stem");
    public static final BlockType MOSSY_COBBLESTONE = get("minecraft:mossy_cobblestone");
    public static final BlockType MYCELIUM = get("minecraft:mycelium");
    public static final BlockType NETHERRACK = get("minecraft:netherrack");
    public static final BlockType NETHER_BRICK_FENCE = get("minecraft:nether_brick_fence");
    public static final BlockType NETHER_BRICK_STAIRS = get("minecraft:nether_brick_stairs");
    public static final BlockType NETHER_WART = get("minecraft:nether_wart");
    public static final BlockType NETHER_WART_BLOCK = get("minecraft:nether_wart_block");
    public static final BlockType OAK_DOOR = get("minecraft:oak_door");
    public static final BlockType OAK_FENCE = get("minecraft:oak_fence");
    public static final BlockType OAK_FENCE_GATE = get("minecraft:oak_fence_gate");
    public static final BlockType OAK_SIGN = get("minecraft:oak_sign");
    public static final BlockType OAK_STAIRS = get("minecraft:oak_stairs");
    public static final BlockType OAK_TRAPDOOR = get("minecraft:oak_trapdoor");
    public static final BlockType OAK_WALL_SIGN = get("minecraft:oak_wall_sign");
    public static final BlockType OBSERVER = get("minecraft:observer");
    public static final BlockType OBSIDIAN = get("minecraft:obsidian");
    public static final BlockType ORANGE_GLAZED_TERRACOTTA = get("minecraft:orange_glazed_terracotta");
    public static final BlockType ORANGE_SHULKER_BOX = get("minecraft:orange_shulker_box");
    public static final BlockType PACKED_ICE = get("minecraft:packed_ice");
    public static final BlockType PINK_GLAZED_TERRACOTTA = get("minecraft:pink_glazed_terracotta");
    public static final BlockType PINK_SHULKER_BOX = get("minecraft:pink_shulker_box");
    public static final BlockType PISTON = get("minecraft:piston");
    public static final BlockType PISTON_HEAD = get("minecraft:piston_head");
    public static final BlockType POTATOES = get("minecraft:potatoes");
    public static final BlockType PRISMARINE = get("minecraft:prismarine");
    public static final BlockType PUMPKIN = get("minecraft:pumpkin");
    public static final BlockType PUMPKIN_STEM = get("minecraft:pumpkin_stem");
    public static final BlockType PURPLE_GLAZED_TERRACOTTA = get("minecraft:purple_glazed_terracotta");
    public static final BlockType PURPLE_SHULKER_BOX = get("minecraft:purple_shulker_box");
    public static final BlockType PURPUR_BLOCK = get("minecraft:purpur_block");
    public static final BlockType PURPUR_PILLAR = get("minecraft:purpur_pillar");
    public static final BlockType PURPUR_SLAB = get("minecraft:purpur_slab");
    public static final BlockType PURPUR_STAIRS = get("minecraft:purpur_stairs");
    public static final BlockType QUARTZ_BLOCK = get("minecraft:quartz_block");
    public static final BlockType QUARTZ_STAIRS = get("minecraft:quartz_stairs");
    public static final BlockType RAIL = get("minecraft:rail");
    public static final BlockType REDSTONE_BLOCK = get("minecraft:redstone_block");
    public static final BlockType REDSTONE_LAMP = get("minecraft:redstone_lamp");
    public static final BlockType REDSTONE_ORE = get("minecraft:redstone_ore");
    public static final BlockType REDSTONE_TORCH = get("minecraft:redstone_torch");
    public static final BlockType REDSTONE_WIRE = get("minecraft:redstone_wire");
    public static final BlockType RED_GLAZED_TERRACOTTA = get("minecraft:red_glazed_terracotta");
    public static final BlockType RED_MUSHROOM = get("minecraft:red_mushroom");
    public static final BlockType RED_MUSHROOM_BLOCK = get("minecraft:red_mushroom_block");
    public static final BlockType RED_SANDSTONE = get("minecraft:red_sandstone");
    public static final BlockType RED_SANDSTONE_STAIRS = get("minecraft:red_sandstone_stairs");
    public static final BlockType RED_SHULKER_BOX = get("minecraft:red_shulker_box");
    public static final BlockType REPEATING_COMMAND_BLOCK = get("minecraft:repeating_command_block");
    public static final BlockType SAND = get("minecraft:sand");
    public static final BlockType SANDSTONE = get("minecraft:sandstone");
    public static final BlockType SANDSTONE_STAIRS = get("minecraft:sandstone_stairs");
    public static final BlockType SEA_LANTERN = get("minecraft:sea_lantern");
    public static final BlockType SNOW = get("minecraft:snow");
    public static final BlockType SOUL_SAND = get("minecraft:soul_sand");
    public static final BlockType SPONGE = get("minecraft:sponge");
    public static final BlockType SPRUCE_DOOR = get("minecraft:spruce_door");
    public static final BlockType SPRUCE_FENCE = get("minecraft:spruce_fence");
    public static final BlockType SPRUCE_FENCE_GATE = get("minecraft:spruce_fence_gate");
    public static final BlockType SPRUCE_STAIRS = get("minecraft:spruce_stairs");
    public static final BlockType STICKY_PISTON = get("minecraft:sticky_piston");
    public static final BlockType STONE = get("minecraft:stone");
    public static final BlockType STONE_BRICK_STAIRS = get("minecraft:stone_brick_stairs");
    public static final BlockType STONE_BUTTON = get("minecraft:stone_button");
    public static final BlockType STONE_PRESSURE_PLATE = get("minecraft:stone_pressure_plate");
    public static final BlockType STONE_SLAB = get("minecraft:stone_slab");
    public static final BlockType STRUCTURE_BLOCK = get("minecraft:structure_block");
    public static final BlockType STRUCTURE_VOID = get("minecraft:structure_void");
    public static final BlockType TNT = get("minecraft:tnt");
    public static final BlockType TORCH = get("minecraft:torch");
    public static final BlockType TRAPPED_CHEST = get("minecraft:trapped_chest");
    public static final BlockType TRIPWIRE = get("minecraft:tripwire");
    public static final BlockType TRIPWIRE_HOOK = get("minecraft:tripwire_hook");
    public static final BlockType MOVING_PISTON = get("minecraft:moving_piston");
    public static final BlockType VINE = get("minecraft:vine");
    public static final BlockType NOTE_BLOCK = get("minecraft:note_block");
    public static final BlockType WATER = get("minecraft:water");
    public static final BlockType WHEAT = get("minecraft:wheat");
    public static final BlockType WHITE_GLAZED_TERRACOTTA = get("minecraft:white_glazed_terracotta");
    public static final BlockType WHITE_SHULKER_BOX = get("minecraft:white_shulker_box");
    public static final BlockType YELLOW_GLAZED_TERRACOTTA = get("minecraft:yellow_glazed_terracotta");
    public static final BlockType YELLOW_SHULKER_BOX = get("minecraft:yellow_shulker_box");

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
