package org.core.world.position.block.details.data.keyed;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public interface KeyedData<T> {

    Class<AttachableKeyedData> ATTACHABLE = AttachableKeyedData.class;
    Class<OpenableKeyedData> OPENABLE = OpenableKeyedData.class;
    Class<WaterLoggedKeyedData> WATER_LOGGED = WaterLoggedKeyedData.class;
    Class<TileEntityKeyedData> TILED_ENTITY = TileEntityKeyedData.class;
    Class<MultiDirectionalKeyedData> MULTI_DIRECTIONAL = MultiDirectionalKeyedData.class;

    Optional<T> getData();
    void setData(T value);

    static Map<String, Class<? extends KeyedData<?>>> getDefaultKeys(){
        Map<String, Class<? extends KeyedData<?>>> map = new HashMap<>();
        map.put("Attachable", ATTACHABLE);
        map.put("Openable", OPENABLE);
        map.put("WaterLogged", WATER_LOGGED);
        map.put("TiledEntity", TILED_ENTITY);
        map.put("MutliDirectional", MULTI_DIRECTIONAL);
        return map;
    }
}
