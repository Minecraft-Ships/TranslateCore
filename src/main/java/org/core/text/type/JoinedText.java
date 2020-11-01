package org.core.text.type;

import java.util.List;

public interface JoinedText extends Text {

    List<Text> getChildren();

    @Override
    default String toLegacyString(){
        StringBuilder builder = new StringBuilder();
        for(Text text : this.getChildren()){
            builder.append(text.toLegacyString());
        }
        return builder.toString();
    }
}
