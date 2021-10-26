package org.core.world.structure;

import org.core.collection.BlockSetSnapshot;
import org.core.entity.EntitySnapshot;
import org.core.platform.plugin.Plugin;
import org.core.vector.type.Vector3;
import org.core.world.WorldExtent;

import java.io.File;
import java.util.Optional;
import java.util.Set;

public interface Structure {

    Optional<String> getId();

    Optional<String> getName();

    Optional<Plugin> getPlugin();

    Set<EntitySnapshot<?>> getEntities();

    Set<BlockSetSnapshot> getBlocks();

    void fillBetween(WorldExtent world, Vector3<Integer> start, Vector3<Integer> end);

    void place(StructurePlacementBuilder builder);

    void serialize(File file);


}
