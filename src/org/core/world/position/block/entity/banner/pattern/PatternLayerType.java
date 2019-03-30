package org.core.world.position.block.entity.banner.pattern;

import org.core.inventory.item.data.dye.DyeType;
import org.core.utils.Identifable;

public interface PatternLayerType extends Identifable {

    PatternLayer createLayer(DyeType type);

}
