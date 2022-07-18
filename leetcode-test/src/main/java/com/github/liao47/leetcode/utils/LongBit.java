package com.github.liao47.leetcode.utils;

/**
 * @author liaoshiqing
 * @date 2022/7/18 9:37
 */
public class LongBit {

    private final int length;
    private final long[] values;

    public LongBit(int length) {
        this.length = length;
        this.values = new long[this.length];
    }

    public static LongBit of(int n) {
        return new LongBit(n / 64 + 1);
    }

    public LongBit or(int index) {
        int idx = index / 64;
        if (idx < this.length) {
            this.values[idx] |= 1L << index % 64;
        }
        return this;
    }

    public LongBit or(LongBit longBit) {
        LongBit result = new LongBit(Math.max(longBit.length, this.length));
        for (int i = 0; i < result.length; i++) {
            long v1 = i < this.length ? this.values[i] : 0L;
            long v2 = i < longBit.length ? longBit.values[i] : 0L;
            result.values[i] = v1 | v2;
        }
        return result;
    }

    public LongBit and(LongBit longBit) {
        LongBit result = new LongBit(Math.min(longBit.length, this.length));
        for (int i = 0; i < result.length; i++) {
            result.values[i] = this.values[i] & longBit.values[i];
        }
        return result;
    }

    public boolean contains(int index) {
        int idx = index / 64;
        if (idx >= this.length) {
            return false;
        }
        return (this.values[idx] & 1L << index % 64) != 0;
    }

    public int indexOfHighest() {
        for (int i = this.values.length - 1; i >= 0; i--) {
            if (values[i] != 0L) {
                return highest(i, values[i]);
            }
        }
        return -1;
    }

    public int indexOfLowest() {
        for (int i = 0; i < this.values.length; i++) {
            if (this.values[i] != 0L) {
                return highest(i, this.values[i] & -this.values[i]);
            }
        }
        return -1;
    }

    private int highest(int idx, long value) {
        int index = 0;
        int k = 32;
        while (k != 0) {
            if (value >>> k != 0) {
                index += k;
                value >>>= k;
            }
            k >>= 1;
        }
        return 64 * idx + index;
    }
}
