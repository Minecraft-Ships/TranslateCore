package org.core.world.position.block.details.blocks.sign;

import org.core.world.position.block.details.RotateDetails;
import org.core.world.position.block.details.TiledBlockDetails;
import org.core.world.position.block.entity.sign.SignTileEntity;
import org.core.world.position.block.entity.sign.SignTileEntitySnapshot;

public interface GeneralSign extends RotateDetails, TiledBlockDetails<SignTileEntity, SignTileEntitySnapshot> {
}
