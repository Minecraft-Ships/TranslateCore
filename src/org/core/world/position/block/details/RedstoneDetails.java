package org.core.world.position.block.details;

/**
 * <p>Any block that officially supports redstone power will implement this</p>
 */
public interface RedstoneDetails extends BlockDetails {

    /**
     * <p>Checks if the BlockDetails is powered</p>
     * @return True if the block is powered, False if not.
     */
    boolean isPowered();

    /**
     * <p>Sets if the BlockDetails is powered</p>
     * @param powered Sets the BlockDetails powered state
     * @return This instance, for chaining.
     */
    RedstoneDetails setPowered(boolean powered);
}
