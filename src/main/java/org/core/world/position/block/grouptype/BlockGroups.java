package org.core.world.position.block.grouptype;

import org.core.CorePlugin;
import org.core.world.position.block.grouptype.versions.BlockGroups1V13;
import org.core.world.position.block.grouptype.versions.CommonBlockGroups;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class BlockGroups {

    private static final BlockGroups IMPLEMENTATION;

    static {
        IMPLEMENTATION = new BlockGroups().registerFields(CommonBlockGroups.class);
        int[] version = CorePlugin.getPlatform().getMinecraftVersion();
        if(version[0] == 1){
            if(version[1] >= 13){
                IMPLEMENTATION.registerFields(BlockGroups1V13.class);
            }
        }
    }

    private final Collection<BlockGroup> groups = new HashSet<>();

    public BlockGroups register(BlockGroup... groups){
        this.groups.addAll(Arrays.asList(groups));
        return this;
    }

    public BlockGroups register(Collection<BlockGroup> groups){
        this.groups.addAll(groups);
        return this;
    }

    public BlockGroups registerFields(Class<?> clazz){
        for (Field field : clazz.getDeclaredFields()){
            if(!Modifier.isStatic(field.getModifiers())){
                continue;
            }
            if (!BlockGroup.class.isAssignableFrom(field.getType())){
                continue;
            }
            try {
                BlockGroup group = (BlockGroup) field.get(null);
                this.groups.add(group);
            } catch (IllegalAccessException ignored) {
            }
        }
        return this;
    }

    public static Optional<BlockGroup> getFromId(String id){
        return values().stream().filter(v -> v.getId().equals(id)).findAny();
    }

    public static Collection<BlockGroup> values(){
        return Collections.unmodifiableCollection(IMPLEMENTATION.groups);
    }
}
