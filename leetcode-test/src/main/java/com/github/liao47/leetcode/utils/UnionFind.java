package com.github.liao47.leetcode.utils;

/**
 * 并查集工具
 * @author liao47
 * @date 2021/1/15 10:56
 */
public class UnionFind {
    private final int[] parent;
    private int count;

    public UnionFind(int length) {
        parent = new int[length];
        count = length;
        for (int i = 0; i < length; i++) {
            parent[i] = i;
        }
    }

    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX == parentY) {
            return;
        }

        count--;
        if (parentX < parentY) {
            parent[parentX] = parentY;
        } else {
            parent[parentY] = parentX;
        }
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public int count() {
        return this.count;
    }
}