package org.core.world.position.block.details.blocks.dispenser;

import org.core.world.position.block.details.RotateDetails;
import org.core.world.position.block.details.TiledBlockDetails;
import org.core.world.position.block.entity.container.dispenser.DispenserTileEntitySnapshot;
import org.core.world.position.block.entity.container.dispenser.LiveDispenserTileEntity;

public interface DispenserBlockDetails extends RotateDetails, TiledBlockDetails<LiveDispenserTileEntity, DispenserTileEntitySnapshot> {
}
