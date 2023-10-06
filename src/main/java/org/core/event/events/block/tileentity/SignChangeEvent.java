package org.core.event.events.block.tileentity;

import org.core.entity.living.human.player.LivePlayer;
import org.core.event.PlatformEvent;
import org.core.event.events.Cancellable;
import org.core.event.events.block.BlockEvent;
import org.core.event.events.entity.EntityEvent;
import org.core.world.position.block.entity.sign.SignSide;
import org.core.world.position.block.entity.sign.SignTileEntitySnapshot;

public interface SignChangeEvent extends PlatformEvent, BlockEvent, Cancellable {

    interface ByPlayer extends SignChangeEvent, EntityEvent<LivePlayer> {

    }

    @Deprecated(forRemoval = true)
    default SignTileEntitySnapshot getTo(){
        return this.getChangingSide().getSign().getSnapshot();
    }

    @Deprecated(forRemoval = true)
    default SignChangeEvent setTo(SignTileEntitySnapshot snapshot) {
        SignSide side = getChangingSide();
        SignSide snapshotSide = snapshot.getSide(side.isFront());
        side.setLines(snapshotSide.getLines());
        return this;
    }

    @Deprecated(forRemoval = true)
    default SignTileEntitySnapshot getFrom() {
        return getSign();
    }

    SignTileEntitySnapshot getSign();

    SignSide getPreviousSide();

    SignSide getChangingSide();

    boolean isEdit();

}
