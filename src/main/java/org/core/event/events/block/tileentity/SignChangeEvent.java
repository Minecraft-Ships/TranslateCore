package org.core.event.events.block.tileentity;

import org.core.entity.living.human.player.LivePlayer;
import org.core.event.PlatformEvent;
import org.core.event.events.Cancellable;
import org.core.event.events.block.BlockEvent;
import org.core.event.events.entity.EntityEvent;
import org.core.world.position.block.entity.sign.SignTileEntitySnapshot;

public interface SignChangeEvent extends PlatformEvent, BlockEvent, Cancellable {

    SignTileEntitySnapshot getTo();
    SignChangeEvent setTo(SignTileEntitySnapshot snapshot);
    SignTileEntitySnapshot getFrom();

    interface ByPlayer extends SignChangeEvent, EntityEvent<LivePlayer> {

    }

}
