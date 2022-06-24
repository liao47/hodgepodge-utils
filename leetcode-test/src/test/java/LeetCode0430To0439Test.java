import com.github.liao47.leetcode.P0430FlattenAMultilevelDoublyLinkedList;
import com.github.liao47.leetcode.P0430FlattenAMultilevelDoublyLinkedList.Node;
import com.github.liao47.leetcode.P0435NonOverlappingIntervals;
import com.github.liao47.leetcode.P0438FindAllAnagramsInAString;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2021/1/8 16:28
 */
public class LeetCode0430To0439Test {
    @Test
    public void test0430() {
        P0430FlattenAMultilevelDoublyLinkedList solver = new P0430FlattenAMultilevelDoublyLinkedList();

        Integer[] params = new Integer[]{1, 2, 3, 4, 5, 6, null, null, null, 7, 8, 9,
                10, null, null, 11, 12};
        Assert.assertArrayEquals(params, Node.parse(params).toArray());
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 7, 8, 11, 12, 9, 10, 4, 5, 6},
                solver.flatten(Node.parse(params)).toArray());

        params = new Integer[]{1, 2, null, 3};
        Assert.assertArrayEquals(new Integer[]{1, 3, 2}, solver.flatten(Node.parse(params)).toArray());

        params = new Integer[0];
        Assert.assertArrayEquals(params, Node.toArray(solver.flatten(Node.parse(params))));

        params = new Integer[]{1, 2, 3, 4, 5, 6, null, null, null, 7, 8, null, null, 11, 12};
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 7, 8, 11, 12, 4, 5, 6},
                solver.flatten(Node.parse(params)).toArray());
    }

    @Test
    public void test0435() {
        P0435NonOverlappingIntervals solver = new P0435NonOverlappingIntervals();
        assertEquals(1, solver.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        assertEquals(2, solver.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        assertEquals(0, solver.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
        assertEquals(2, solver.eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}));
        assertEquals(2, solver.eraseOverlapIntervals(new int[][]{{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}}));
    }

    @Test
    public void test0438() {
        P0438FindAllAnagramsInAString solver = new P0438FindAllAnagramsInAString();
        assertEquals(Arrays.asList(0, 6), solver.findAnagrams("cbaebabacd", "abc"));
        assertEquals(Arrays.asList(0, 1, 2), solver.findAnagrams("abab", "ab"));
        assertEquals(Arrays.asList(3, 4, 6), solver.findAnagrams("abaacbabc", "abc"));
    }
}
