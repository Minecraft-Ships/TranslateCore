package org.core.world.position.block.details.blocks.stairs;

import org.core.world.position.block.details.BidirectionalDetails;
import org.core.world.position.block.details.RotateDetails;
import org.core.world.position.block.details.WaterLogged;

public interface GeneralStairs extends RotateDetails, BidirectionalDetails, WaterLogged {

    enum Shape {

        DEFAULT,
        INNER_LEFT,
        INNER_RIGHT,
        OUTER_LEFT,
        OUTER_RIGHT

    }

    Shape getShape();
    GeneralStairs setShape(Shape shape);
}
