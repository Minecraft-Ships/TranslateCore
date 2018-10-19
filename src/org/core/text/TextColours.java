package org.core.text;

import org.core.CorePlugin;
import org.core.utils.Guaranteed;

public class TextColours implements Guaranteed<TextColour> {

    public static TextColour YELLOW = CorePlugin.getPlatform().get(new TextColours("Yellow"));
    public static TextColour BLUE = CorePlugin.getPlatform().get(new TextColours("Blue"));
    public static TextColour GREEN = CorePlugin.getPlatform().get(new TextColours("Green"));

    public static String stripColours(String message){
        if(message == null){
            return null;
        }
        String ret = message;
        for (TextColour colour : CorePlugin.getPlatform().get(TextColour.class)){
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
