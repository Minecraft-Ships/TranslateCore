package org.core.vector;

import org.core.vector.types.Vector3Int;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

/**
 * Immutable 3 dimensional Vector with a specified Number type
 * @param <N> The number type
 */
public interface Vector3<N extends Number>{

    /**
     * Gets the X of the Vector
     * @return The X value
     */
    N getX();

    /**
     * Gets the Y of the Vector
     * @return The Y value
     */
    N getY();

    /**
     * Gets the Z of the Vector
     * @return The Z value
     */
    N getZ();

    /**
     * Adds a vector to this vector.
     * @param vector The vector to add
     * @return The added vector
     */
    Vector3<N> add(Vector3<N> vector);

    /**
     * Adds a Vector3Int to the current Vector,
     * @param vector The vector to add
     * @return The added vector
     */
    Vector3<N> add(Vector3Int vector);

    /**
     * Minus the target vector from this vector
     * @param vector The vector to minus
     * @return The resulting Vector
     */
    Vector3<N> minus(Vector3<N> vector);

    /**
     * Divide the Vector by the amount
     * @param amount The amount to divide by
     * @return the resulting Vector
     */
    Vector3<N> divide(BigDecimal amount);

    /**
     * Multiply the Vector by the amount
     * @param amount the amount to multiply by
     * @return the resulting Vector
     */
    Vector3<N> multiply(BigDecimal amount);

    /**
     * Gets the raw big decimal value of X
     * @return The raw value of X
     */
    BigDecimal getRawX();

    /**
     * Gets the raw big decimal value of Y
     * @return The raw value of Y
     */
    BigDecimal getRawY();

    /**
     * Gets the raw big decimal value of Z
     * @return The raw value of Z
     */
    BigDecimal getRawZ();

    /**
     * Converts the vector to another Vector type
     * @param class1 The Vector class to convert to
     * @param <E> The number type
     * @return The resulting Vector
     */
    default <E extends Number> Vector3<E> to(Class<? extends Vector3<E>> class1){
        try {
            return class1.getConstructor(BigDecimal.class, BigDecimal.class, BigDecimal.class).newInstance(getRawX(), getRawY(), getRawZ());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets the distance squared between the two vectors
     * @param vector3 The vector to compare
     * @return The distances squared between both values
     */
    default double distanceSquared(Vector3<? extends Number> vector3){
        double x = this.getRawX().doubleValue() - vector3.getRawX().doubleValue();
        double y = this.getRawY().doubleValue() - vector3.getRawY().doubleValue();
        double z = this.getRawZ().doubleValue() - vector3.getRawZ().doubleValue();
        return x * x + y * y + z * z;
    }

    /**
     * Gets the distance between the two vectors
     * @param vector3 The vector to compare
     * @return The distance between both values
     */
    default double distance(Vector3<? extends Number> vector3){
        return Math.sqrt(distanceSquared(vector3));
    }

    /**
     * Multiplies the vector by the value
     * @param value The value to multiply by
     * @return The resulting Vector
     */
    default Vector3<N> multiply(double value){
        return this.multiply(new BigDecimal(value));
    }

    /**
     * Divides the vector by the value
     * @param value The value to divide by
     * @return The resulting Vector
     */
    default Vector3<N> divide(double value){
        return this.divide(new BigDecimal(value));
    }
}
