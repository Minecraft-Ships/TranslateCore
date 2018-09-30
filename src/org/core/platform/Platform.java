package org.core.platform;

import org.core.entity.Entity;
import org.core.entity.EntityTypes;
import org.core.inventory.item.ItemTypes;
import org.core.utils.Identifable;
import org.core.world.position.block.BlockTypes;

public interface Platform {

    public int[] getMinecraftVersion();

    public <T extends Identifable> T get(BlockTypes blockId);
    public <T extends Identifable> T get(ItemTypes itemId);
    public <T extends Identifable, E extends Entity> T get(EntityTypes<E> entityId);

}
