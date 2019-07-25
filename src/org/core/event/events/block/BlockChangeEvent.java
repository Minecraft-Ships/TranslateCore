package org.core.event.events.block;

import org.core.entity.living.human.player.LivePlayer;
import org.core.entity.scene.droppeditem.DroppedItemSnapshot;
import org.core.event.PlatformEvent;
import org.core.event.events.Cancellable;
import org.core.event.events.entity.EntityEvent;
import org.core.world.expload.Explosion;
import org.core.world.position.block.details.BlockDetails;

import java.util.Collection;

public interface BlockChangeEvent extends BlockEvent, PlatformEvent {

    BlockDetails getBeforeState();
    BlockDetails getAfterState();

    interface Break extends BlockChangeEvent {

        interface ByPlayer extends Break, Cancellable, EntityEvent<LivePlayer> {

        }

        interface ByExplosion extends Break, Cancellable {

            Explosion getExplosion();

        }

        interface Post extends Break {

            Collection<DroppedItemSnapshot> getItems();

            BlockChangeEvent.Break.Post removeItem(DroppedItemSnapshot snapshot);

            interface ByPlayer extends Post, EntityEvent<LivePlayer> {


            }
        }
    }

    interface Place extends BlockChangeEvent {

        interface ByPlayer extends Place, Cancellable, EntityEvent<LivePlayer> {

        }
    }
}
