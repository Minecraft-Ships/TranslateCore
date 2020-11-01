package org.core.text.colour;

public enum NamedTextColours implements TextColour.Named, TextColour.Legacy {

    BLACK("Black", '0', 0,0, 0),
    DARK_BLUE("Dark_Blue", '1', 0, 0, 170),
    DARK_GREEN("Dark_Green", '2', 0, 170, 0),
    DARK_AQUA("Dark_Aqua", '3', 0, 170, 170),
    DARK_RED("Dark_Red", '4', 170, 0, 0),
    DARK_PURPLE("Dark_Purple", '5', 170, 0, 170),
    GOLD("Gold", '6', 255, 170, 0),
    GRAY("Gray", '7', 170, 170, 170),
    DARK_GRAY("Dark_Gray", '8', 85, 85, 85),
    BLUE("Blue", '9', 85, 85, 255),
    GREEN("Green", 'a', 85, 255, 85),
    AQUA("Aqua", 'b', 85, 255, 255),
    RED("Red", 'c', 255, 85, 85),
    LIGHT_PURPLE("Light_Purple", 'd', 255, 85, 255),
    YELLOW("Yellow", 'e', 255, 255, 85),
    WHITE("White", 'f', 255, 255, 255);

    private final String name;
    private final char legacySign;
    private final int red;
    private final int green;
    private final int blue;

    NamedTextColours(String name, char sign, int red, int green, int blue){
        this.name = name;
        this.legacySign = sign;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public char getLegacySign() {
        return this.legacySign;
    }

    @Override
    public int getRed() {
        return this.red;
    }

    @Override
    public int getGreen() {
        return this.green;
    }

    @Override
    public int getBlue() {
        return this.blue;
    }

    public static NamedTextColours valueOf(int red, int green, int blue){
        for(NamedTextColours colour : values()){
            if(colour.getBlue() != blue){
                continue;
            }
            if(colour.getGreen() != green){
                continue;
            }
            if(colour.getRed() != red){
                continue;
            }
            return colour;
        }
        return null;
    }
}
