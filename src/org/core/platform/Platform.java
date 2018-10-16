package org.core.platform;

import org.core.entity.Entity;
import org.core.entity.EntitySnapshot;
import org.core.entity.EntityTypes;
import org.core.inventory.item.ItemTypes;
import org.core.text.TextColour;
import org.core.text.TextColours;
import org.core.utils.Identifable;
import org.core.world.position.block.BlockTypes;

import java.util.Optional;
import java.util.Set;

public interface Platform {

    public int[] getMinecraftVersion();

    public Set<Plugin> getPlugins();
    public <T extends Identifable> T get(BlockTypes blockId);
    public <T extends Identifable> T get(ItemTypes itemId);
    public <T extends Identifable, E extends Entity, S extends EntitySnapshot<E>> T get(EntityTypes<E, S> entityId);
    TextColour get(TextColours id);

    public default Optional<Plugin> getPlugin(String name){
        return getPlugins().stream().filter(p -> p.getPluginName().equals(name)).findAny();
    }
}
