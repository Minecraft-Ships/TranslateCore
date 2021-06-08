package org.core.command.argument.arguments.position.vector;

import org.core.command.argument.CommandArgument;
import org.core.command.argument.arguments.simple.number.IntegerArgument;

import java.math.BigDecimal;


public class Vector3IntegerArgument extends Vector3Argument<Integer> {

    public Vector3IntegerArgument(String id, CommandArgument<Integer> xArgument, CommandArgument<Integer> yArgument, CommandArgument<Integer> zArgument) {
        super(id, BigDecimal::intValue, xArgument, yArgument, zArgument);
    }

    public Vector3IntegerArgument(String id, CommandArgument<Integer> argument) {
        this(id, argument, argument, argument);
    }

    public Vector3IntegerArgument(String id) {
        this(id, new IntegerArgument(id));
    }
}
