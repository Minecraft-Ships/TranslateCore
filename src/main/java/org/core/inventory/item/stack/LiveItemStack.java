package org.core.inventory.item.stack;

import org.core.TranslateCore;
import org.core.entity.Entity;
import org.core.entity.InventoryHoldingEntity;
import org.core.entity.ItemHoldingEntity;
import org.core.world.Extent;
import org.core.world.position.block.entity.LiveTileEntity;
import org.core.world.position.block.entity.container.ContainerTileEntity;
import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.impl.sync.SyncExactPosition;

import java.util.Optional;

public interface LiveItemStack extends ItemStack {

    default Optional<SyncExactPosition> getPosition() {
        Optional<SyncExactPosition> opPositionFromTile = TranslateCore
                .getServer()
                .getWorldExtents()
                .flatMap(Extent::getLiveTileEntities)
                .filter(entity -> entity instanceof ContainerTileEntity)
                .map(entity -> (ContainerTileEntity) entity)
                .filter(entity -> entity
                        .getInventory()
                        .getItemSlots()
                        .anyMatch(slot -> slot.getItem().map(item -> item.equals(this)).orElse(false)))
                .map(entity -> ((LiveTileEntity) entity).getPosition())
                .map(SyncBlockPosition::toExactPosition)
                .findFirst();
        if (opPositionFromTile.isPresent()) {
            return opPositionFromTile;
        }
        return TranslateCore.getServer().getWorldExtents().flatMap(Extent::getLiveEntities).filter(entity -> {
            if (entity instanceof ItemHoldingEntity) {
                ItemHoldingEntity<?> ihEntity = (ItemHoldingEntity<?>) entity;
                if (ihEntity.getHoldingItem().getItem().map(item -> item.equals(this)).orElse(false)) {
                    return true;
                }
            }
            if (entity instanceof InventoryHoldingEntity) {
                InventoryHoldingEntity<?> ihEntity = (InventoryHoldingEntity<?>) entity;
                return ihEntity
                        .getInventory()
                        .getItemSlots()
                        .filter(slot -> slot.getItem().isPresent())
                        .anyMatch(slot -> slot.getItem().get().equals(this));
            }
            return false;
        }).findFirst().map(Entity::getPosition);
    }
}
