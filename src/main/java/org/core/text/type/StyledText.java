package org.core.text.type;

import org.core.text.colour.TextColour;
import org.core.text.style.TextStyle;

import java.util.Optional;
import java.util.Set;

public interface StyledText extends Text.Charactable {

    Set<TextStyle> getTextStyle();

    @Override
    default String toLegacyString(){
        StringBuilder builder = new StringBuilder();
        for(TextStyle style : this.getTextStyle()){
            if(style instanceof TextStyle.Legacy) {
                builder.append(Text.LEGACY_CHARACTER_CODE + ((TextStyle.Legacy)style).getLegacySign());
            }
        }
        builder.append(this.getText());
        return builder.toString();
    }
}
