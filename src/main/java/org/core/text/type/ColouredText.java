package org.core.text.type;

import org.core.text.colour.TextColour;

import java.util.Optional;

public interface ColouredText extends Text.Charactable {

    Optional<TextColour> getColour();

    @Override
    default String toLegacyString(){
        StringBuilder builder = new StringBuilder();
        if(this.getColour().isPresent() && this.getColour().get() instanceof TextColour.Legacy){
            return Text.LEGACY_CHARACTER_CODE + ((TextColour.Legacy)this.getColour().get()).getLegacySign() + this.getText();
        }
        return this.getText();
    }
}
