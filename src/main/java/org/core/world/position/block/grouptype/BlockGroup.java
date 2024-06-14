package org.core.world.position.block.grouptype;

import org.core.utils.Identifiable;
import org.core.world.position.block.BlockType;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class BlockGroup implements Identifiable {

    private final String id;
    private final String name;
    private final Supplier<Stream<BlockType>> grouped;

    public BlockGroup(String id, String name, BlockType... types) {
        this(id, name, () -> Stream.of(types));
    }

    public BlockGroup(String id, String name, Collection<BlockType> types) {
        this(id, name, types::stream);
    }

    public BlockGroup(String id, String name, Supplier<Stream<BlockType>> types) {
        this.id = id;
        this.name = name;
        this.grouped = types;
    }

    @Deprecated(forRemoval = true)
    public BlockType[] getGrouped() {
        return this.grouped.get().toArray(BlockType[]::new);
    }

    public Stream<BlockType> getBlocks() {
        return this.grouped.get();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
