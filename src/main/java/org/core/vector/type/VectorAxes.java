package org.core.vector.type;

public final class VectorAxes {

    public static final VectorAxis X = new VectorAxis('X') {
        @Override
        public <N extends Number> N get(Vector3<N> vector) {
            return vector.getX();
        }
    };

    public static final VectorAxis Y = new VectorAxis('Y') {
        @Override
        public <N extends Number> N get(Vector3<N> vector) {
            return vector.getY();
        }
    };

    public static final VectorAxis Z = new VectorAxis('Z') {
        @Override
        public <N extends Number> N get(Vector3<N> vector) {
            return vector.getZ();
        }
    };

    private VectorAxes() {
        throw new RuntimeException("Do not generate");
    }
}
