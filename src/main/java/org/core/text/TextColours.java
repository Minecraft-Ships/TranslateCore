package org.core.text;

import org.core.TranslateCore;
import org.core.utils.Guaranteed;

@Deprecated
public class TextColours implements Guaranteed<TextColour> {

    public static final TextColour YELLOW = TranslateCore.getPlatform().get(new TextColours("Yellow"));
    public static final TextColour BLUE = TranslateCore.getPlatform().get(new TextColours("Blue"));
    public static final TextColour GREEN = TranslateCore.getPlatform().get(new TextColours("Green"));
    public static final TextColour RED = TranslateCore.getPlatform().get(new TextColours("Red"));
    public static final TextColour AQUA = TranslateCore.getPlatform().get(new TextColours("Aqua"));
    public static final TextColour RESET = TranslateCore.getPlatform().get(new TextColours("Reset"));

    public static String stripColours(String message){
        if(message == null){
            return null;
        }
        String ret = message;
        for (TextColour colour : TranslateCore.getPlatform().getTextColours()){
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
