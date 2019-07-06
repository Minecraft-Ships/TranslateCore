package org.core.command.argument.arguments.vector;

import org.core.command.argument.ArgumentContext;
import org.core.command.argument.CommandContext;
import org.core.vector.types.Vector3Double;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Vector3DoubleArgument implements ArgumentContext<Vector3Double> {

    String id;

    public Vector3DoubleArgument(String id){
        this.id = id;
    }

    @Override
    public Vector3Double parse(CommandContext context) throws IOException {
        String v1 = context.next();
        String v2 = context.next();
        String v3 = context.next();
        try{
            double i1 = Double.parseDouble(v1);
            double i2 = Double.parseDouble(v2);
            double i3 = Double.parseDouble(v3);
            return new Vector3Double(i1, i2, i3);
        }catch (NumberFormatException e){
            throw new IOException("Not a number");
        }
    }

    @Override
    public List<String> getSuggestions(CommandContext context, String... args) {
        return new ArrayList<>();
    }

    @Override
    public String getId() {
        return this.id;
    }
}
