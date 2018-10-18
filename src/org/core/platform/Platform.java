package org.core.platform;

import org.core.entity.Entity;
import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.inventory.item.ItemType;
import org.core.inventory.item.ItemTypes;
import org.core.text.TextColour;
import org.core.text.TextColours;
import org.core.utils.Guaranteed;
import org.core.utils.Identifable;
import org.core.world.position.block.BlockType;
import org.core.world.position.block.BlockTypes;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface Platform {

    int[] getMinecraftVersion();

    Set<Plugin> getPlugins();
    <T extends Identifable> Collection<T> get(Class<T> class1);
    <T extends Identifable> T get(Guaranteed<T> guaranteed);
    BlockType get(BlockTypes blockId);
    ItemType get(ItemTypes itemId);
    <E extends Entity, S extends EntitySnapshot<E>> EntityType<E, S> get(EntityTypes<E, S> entityId);
    TextColour get(TextColours id);

    <T extends Identifable> Optional<T> get(String id, Class<T> type);

    public default Optional<Plugin> getPlugin(String name){
        return getPlugins().stream().filter(p -> p.getPluginName().equals(name)).findAny();
    }
}
