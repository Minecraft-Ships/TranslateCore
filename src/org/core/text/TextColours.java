package org.core.text;

import org.core.CorePlugin;
import org.core.utils.Guaranteed;

public class TextColours implements Guaranteed<TextColour> {

    public static TextColour YELLOW = CorePlugin.getPlatform().get(new TextColours("Yellow"));

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
