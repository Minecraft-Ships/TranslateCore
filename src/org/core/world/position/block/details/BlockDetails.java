package org.core.world.position.block.details;

import org.core.world.position.block.BlockType;

/**
 * <p>Contains all information of a block that has not been placed</p>
 */
public interface BlockDetails {

    /**
     * Gets the BlockType variant this BlockDetails is
     * @return The connected BlockType variant
     */
    BlockType getType();

    /**
     * Creates a copy of the BlockDetails
     * @return The copy of the BlockDetails
     */
    BlockDetails createCopyOf();
}
