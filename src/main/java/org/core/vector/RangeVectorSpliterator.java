package org.core.vector;

import org.core.utils.Bounds;
import org.core.vector.type.Vector3;
import org.jetbrains.annotations.NotNull;

import java.util.Spliterator;
import java.util.function.Consumer;

public class RangeVectorSpliterator implements Spliterator<Vector3<Integer>> {

    private final @NotNull Vector3<Integer> min;
    private @NotNull Vector3<Integer> max;
    private int indexX;
    private int indexY;
    private int indexZ;

    public RangeVectorSpliterator(@NotNull Bounds<Integer> bounds) {
        this(bounds.getIntMin(), bounds.getIntMax());
    }

    public RangeVectorSpliterator(@NotNull Vector3<Integer> min, @NotNull Vector3<Integer> max) {
        if (min.getX() > max.getX()) {
            throw new IllegalArgumentException("X is greater on the min then the max");
        }
        if (min.getY() > max.getY()) {
            throw new IllegalArgumentException("Y is greater on the min then the max");
        }
        if (min.getZ() > max.getZ()) {
            throw new IllegalArgumentException("Z is greater on the min then the max");
        }
        this.max = max;
        this.min = min;
    }


    @Override
    public boolean tryAdvance(Consumer<? super Vector3<Integer>> consumer) {
        int indexX = min.getX() + this.indexX;
        int indexY = min.getY() + this.indexY;
        int indexZ = min.getZ() + this.indexZ;
        if (indexX < this.max.getX()) {
            consumer.accept(Vector3.valueOf(indexX, indexY, indexZ));
            this.indexX++;
            return true;
        }
        if (indexZ < this.max.getZ()) {
            this.indexX = 0;
            indexX = 0;
            indexZ++;
            consumer.accept(Vector3.valueOf(indexX, indexY, indexZ));
            this.indexZ++;
            return true;
        }
        if (indexY < this.max.getY()) {
            this.indexX = 0;
            this.indexZ = 0;
            indexX = 0;
            indexZ = 0;
            indexY++;
            consumer.accept(Vector3.valueOf(indexX, indexY, indexZ));
            this.indexY++;
            return true;
        }
        return false;
    }

    @Override
    public RangeVectorSpliterator trySplit() {
        int indexX = this.indexX = this.min.getX();
        int indexY = this.indexY + this.min.getY();
        int indexZ = this.indexZ + this.min.getZ();
        if (indexY + 2 <= this.max.getZ()) {
            int differenceY = this.max.getY() - indexY;
            int halfPoint = differenceY / 2;

            Vector3<Integer> newMax = Vector3.valueOf(this.max.getX(), halfPoint, this.max.getZ());
            Vector3<Integer> splitMin = Vector3.valueOf(this.min.getX(), halfPoint, this.min.getZ());
            RangeVectorSpliterator split = new RangeVectorSpliterator(splitMin, this.max);
            this.max = newMax;
            return split;
        }

        if (indexZ + 2 <= max.getZ()) {
            int differenceZ = this.max.getZ() - indexZ;
            int halfPoint = differenceZ / 2;

            Vector3<Integer> newMax = Vector3.valueOf(this.max.getX(), this.max.getY(), halfPoint);
            Vector3<Integer> splitMin = Vector3.valueOf(this.min.getX(), this.min.getY(), halfPoint);
            RangeVectorSpliterator split = new RangeVectorSpliterator(splitMin, this.max);
            this.max = newMax;
            return split;
        }

        if (indexX + 2 <= max.getX()) {
            int differenceX = this.max.getX() - indexX;
            int halfPoint = differenceX / 2;

            Vector3<Integer> newMax = Vector3.valueOf(halfPoint, this.max.getY(), this.max.getZ());
            Vector3<Integer> splitMin = Vector3.valueOf(halfPoint, this.min.getY(), this.min.getZ());
            RangeVectorSpliterator split = new RangeVectorSpliterator(splitMin, this.max);
            this.max = newMax;
            return split;
        }
        return null;
    }

    @Override
    public long estimateSize() {
        long diffX = this.max.getX() - this.min.getX();
        long diffY = this.max.getY() - this.min.getY();
        long diffZ = this.max.getZ() - this.min.getX();
        return diffZ * diffX * diffY;
    }

    @Override
    public int characteristics() {
        return ORDERED | SIZED | SUBSIZED | NONNULL | DISTINCT;
    }
}
