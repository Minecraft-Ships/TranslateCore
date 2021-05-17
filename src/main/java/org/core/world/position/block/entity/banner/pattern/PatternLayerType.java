package org.core.world.position.block.entity.banner.pattern;

import org.core.inventory.item.data.dye.DyeType;
import org.core.utils.Identifiable;

public interface PatternLayerType extends Identifiable {

    PatternLayer createLayer(DyeType type);

}
