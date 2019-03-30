package org.core.world.position.block.entity.banner.pattern;

import org.core.inventory.item.data.dye.DyeType;

public interface PatternLayer {

    DyeType getColour();
    PatternLayer setColour(DyeType type);

    PatternLayerType getPattern();
    PatternLayer setPattern(PatternLayerType type);
}
