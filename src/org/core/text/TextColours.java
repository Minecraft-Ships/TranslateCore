package org.core.text;

import org.core.CorePlugin;
import org.core.utils.Guaranteed;

public class TextColours implements Guaranteed<TextColour> {

    public static final TextColour YELLOW = CorePlugin.getPlatform().get(new TextColours("Yellow"));
    public static final TextColour BLUE = CorePlugin.getPlatform().get(new TextColours("Blue"));
    public static final TextColour GREEN = CorePlugin.getPlatform().get(new TextColours("Green"));
    public static final TextColour RED = CorePlugin.getPlatform().get(new TextColours("Red"));
    public static final TextColour AQUA = CorePlugin.getPlatform().get(new TextColours("Aqua"));
    public static final TextColour RESET = CorePlugin.getPlatform().get(new TextColours("Reset"));

    public static String stripColours(String message){
        if(message == null){
            return null;
        }
        String ret = message;
        for (TextColour colour : CorePlugin.getPlatform().get(TextColour.class)){
            if(colour == null){
                System.err.println("Colour was not found");
                continue;
            }
            ret = ret.replaceAll(colour.formatChar(), "");
        }
        return ret;
    }


    private String name;

    private TextColours(String name){
        this.name = name;
    }

    @Override
    public String getId() {
        return "minecraft:" + name.toLowerCase();
    }

    @Override
    public String getName() {
        return this.name;
    }
}
