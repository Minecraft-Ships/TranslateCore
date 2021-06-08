package org.core.command.argument.arguments.position.vector;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.arguments.simple.number.DoubleArgument;

import java.math.BigDecimal;


public class Vector3DoubleArgument extends Vector3Argument<Double> {

    public Vector3DoubleArgument(String id, CommandArgument<Double> xArgument, CommandArgument<Double> yArgument, CommandArgument<Double> zArgument) {
        super(id, BigDecimal::doubleValue, xArgument, yArgument, zArgument);
    }

    public Vector3DoubleArgument(String id, CommandArgument<Double> argument) {
        this(id, argument, argument, argument);
    }

    public Vector3DoubleArgument(String id) {
        this(id, new DoubleArgument(id));
    }
}
