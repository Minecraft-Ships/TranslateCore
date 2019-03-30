package org.core.platform;

import org.core.configuration.type.ConfigurationLoaderType;
import org.core.configuration.type.ConfigurationLoaderTypes;
import org.core.entity.Entity;
import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.inventory.item.ItemType;
import org.core.inventory.item.ItemTypes;
import org.core.inventory.item.data.dye.DyeType;
import org.core.inventory.item.data.dye.DyeTypes;
import org.core.text.TextColour;
import org.core.text.TextColours;
import org.core.utils.Guaranteed;
import org.core.utils.Identifable;
import org.core.world.position.block.BlockType;
import org.core.world.position.block.BlockTypes;
import org.core.world.position.block.entity.banner.pattern.PatternLayerType;
import org.core.world.position.block.entity.banner.pattern.PatternLayerTypes;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface Platform {

    BlockType get(BlockTypes blockId);
    ItemType get(ItemTypes itemId);
    TextColour get(TextColours id);
    DyeType get(DyeTypes id);
    PatternLayerType get(PatternLayerTypes id);
    ConfigurationLoaderType get(ConfigurationLoaderTypes id);
    <E extends Entity, S extends EntitySnapshot<E>> EntityType<E, S> get(EntityTypes<E, S> entityId);

    Collection<EntityType<? extends Entity, ? extends EntitySnapshot<? extends Entity>>> getEntityTypes();
    Collection<BlockType> getBlockTypes();
    Collection<ItemType> getItemTypes();
    Collection<TextColour> getTextColours();
    Collection<DyeType> getDyeTypes();
    Collection<PatternLayerType> getPatternLayerTypes();
    Collection<ConfigurationLoaderType> getConfigurationLoaderTypes();

    int[] getMinecraftVersion();
    Set<Plugin> getPlugins();

    default Optional<Plugin> getPlugin(String name){
        return getPlugins().stream().filter(p -> p.getPluginName().equals(name)).findAny();
    }

    @Deprecated
    default <T extends Identifable> Collection<T> get(Class<T> class1){
        if(class1.isAssignableFrom(EntityType.class)){
            return (Collection<T>)getEntityTypes();
        }
        if(class1.isAssignableFrom(BlockType.class)){
            return (Collection<T>)getBlockTypes();
        }
        if(class1.isAssignableFrom(BlockType.class)){
            return (Collection<T>)getBlockTypes();
        }
        if(class1.isAssignableFrom(ItemType.class)){
            return (Collection<T>)getItemTypes();
        }
        if(class1.isAssignableFrom(TextColour.class)){
            return (Collection<T>)getTextColours();
        }
        if(class1.isAssignableFrom(DyeType.class)){
            return (Collection<T>)getDyeTypes();
        }
        if(class1.isAssignableFrom(PatternLayerType.class)){
            return (Collection<T>)getPatternLayerTypes();
        }
        if(class1.isAssignableFrom(ConfigurationLoaderType.class)) {
            return (Collection<T>) getConfigurationLoaderTypes();
        }
        return null;
    }

    @Deprecated
    default <T extends Identifable> T get(Guaranteed<T> guaranteed){
        if(guaranteed instanceof EntityType){
            return (T)get((EntityTypes)guaranteed);
        }
        if(guaranteed instanceof BlockTypes){
            return (T)get((BlockTypes)guaranteed);
        }
        if(guaranteed instanceof ItemTypes){
            return (T)get((ItemTypes)guaranteed);
        }
        if(guaranteed instanceof TextColours){
            return (T)get((TextColours)guaranteed);
        }
        if(guaranteed instanceof DyeTypes){
            return (T)get((DyeTypes)guaranteed);
        }
        if(guaranteed instanceof PatternLayerTypes){
            return (T)get((PatternLayerTypes)guaranteed);
        }
        if(guaranteed instanceof ConfigurationLoaderTypes){
            return (T)get((ConfigurationLoaderTypes)guaranteed);
        }
        return null;
    }

    @Deprecated
    default <T extends Identifable> Optional<T> get(String id, Class<T> type) {
        return get(type).stream().filter(t -> t.getId().equals(id)).findAny();
    }

}
