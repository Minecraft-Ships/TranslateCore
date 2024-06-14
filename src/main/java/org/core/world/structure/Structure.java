package org.core.world.structure;

import org.core.collection.BlockSetDetails;
import org.core.entity.EntitySnapshot;
import org.core.platform.plugin.Plugin;
import org.core.vector.type.Vector3;
import org.core.world.WorldExtent;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Structure {

    Optional<String> getId();

    Optional<String> getName();

    Optional<Plugin> getPlugin();

    Set<EntitySnapshot<?>> getEntities();

    @Deprecated(forRemoval = true)
    default Set<BlockSetDetails> getBlocks() {
        return getBlockDetails().collect(Collectors.toSet());
    }

    Stream<BlockSetDetails> getBlockDetails();

    Vector3<Integer> getSize();

    void fillBetween(WorldExtent world, Vector3<Integer> start, Vector3<Integer> end);

    void place(StructurePlacementBuilder builder);

    void serialize(File file) throws IOException;

}
