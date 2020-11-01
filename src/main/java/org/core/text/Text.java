package org.core.text;

@Deprecated
public interface Text {

    boolean equalsExact(String chars);
    String toPlain();
    Text append(Text... text);

    default boolean equalsPlain(String text, boolean ignorecase){
        return ignorecase ? toPlain().equalsIgnoreCase(text) : toPlain().equals(text);
    }

}
