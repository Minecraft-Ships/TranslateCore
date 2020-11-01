package org.core.text.style;

public interface TextStyle {

    interface Named extends TextStyle {

        String getStyleName();

    }

    interface Legacy extends TextStyle {

        char getLegacySign();
    }


}
