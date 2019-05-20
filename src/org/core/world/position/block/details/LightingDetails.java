package org.core.world.position.block.details;

/**
 * <p>If the BlockDetails can be lit in any way (Furnace burning, Redstone lamp being on) then this will be implemented</p>
 */
public interface LightingDetails extends BlockDetails {

    /**
     * <p>Gets if the BlockDetails is lit</p>
     * @return True if the BlockDetails is lit, False if not
     */
    boolean isLit();

    /**
     * <p>Sets if the BlockDetails is lit or not</p>
     * @param lit value to set to
     * @return This instance for chaining
     */
    LightingDetails setLit(boolean lit);
}
