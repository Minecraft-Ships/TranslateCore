package org.core.command.argument.arguments.vector;

import org.core.command.argument.ArgumentContext;
import org.core.command.argument.CommandContext;
import org.core.vector.types.Vector3Int;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Vector3IntArgument implements ArgumentContext<Vector3Int> {

    String id;

    public Vector3IntArgument(String id){
        this.id = id;
    }

    @Override
    public Vector3Int parse(CommandContext context) throws IOException {
        String v1 = context.next();
        String v2 = context.next();
        String v3 = context.next();
        try{
            int i1 = Integer.parseInt(v1);
            int i2 = Integer.parseInt(v2);
            int i3 = Integer.parseInt(v3);
            return new Vector3Int(i1, i2, i3);
        }catch (NumberFormatException e){
            throw new IOException("Not a whole number");
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
