package org.core.world.position.block.grouptype;

import org.core.utils.Identifable;
import org.core.world.position.block.BlockType;

public interface BlockGroup extends Identifable {

    BlockType[] getGrouped();

}
