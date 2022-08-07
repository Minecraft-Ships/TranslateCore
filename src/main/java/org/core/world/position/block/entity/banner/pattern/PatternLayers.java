package org.core.world.position.block.entity.banner.pattern;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public interface PatternLayers {

    List<PatternLayer> getLayers();

    PatternLayers addLayers(Collection<? extends PatternLayer> layers);

    PatternLayers addLayer(int A, PatternLayer layer);

    PatternLayers removeLayer(int layer);

    PatternLayers removeLayers();

    PatternLayersSnapshot createSnapshot();

    default PatternLayers addLayers(PatternLayer... layers) {
        return this.addLayers(Arrays.asList(layers));
    }
}
