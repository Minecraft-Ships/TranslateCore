package org.core.world.position.block.entity.sign;

import net.kyori.adventure.text.Component;

import java.util.*;

public interface SignSide {

    SignTileEntity getSign();

    List<Component> getLines();

    SignSide setLines(Collection<Component> componentCollection);

    default SignSide setLines(Component... lines) {
        return this.setLines(Arrays.asList(lines));
    }

    default Optional<Component> getLineAt(int line) {
        List<Component> lines = this.getLines();
        if (lines.size() <= line) {
            return Optional.empty();
        }
        return Optional.of(lines.get(line));
    }

    default SignSide setLineAt(int line, Component text) {
        List<Component> lines = new ArrayList<>(this.getLines());
        lines.set(line, text);
        return this.setLines(lines);
    }

    boolean isFront();

    boolean isGlowing();

    void setGlowing(boolean glowing);


}
