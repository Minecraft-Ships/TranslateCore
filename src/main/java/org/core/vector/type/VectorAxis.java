package org.core.vector.type;

public abstract class VectorAxis {

    private final char character;

    VectorAxis(char character) {
        this.character = character;
    }

    public abstract <N extends Number> N get(Vector3<N> vector);

    public char getCharacter() {
        return this.character;
    }

}
