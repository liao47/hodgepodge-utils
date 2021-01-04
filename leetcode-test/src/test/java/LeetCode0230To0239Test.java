import com.github.liao47.leetcode.P0239SlidingWindowMaximum;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2021/1/4 14:02
 */
public class LeetCode0230To0239Test {
    @Test
    public void test0239() {
        P0239SlidingWindowMaximum solver = new P0239SlidingWindowMaximum();
        assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, solver.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        assertArrayEquals(new int[]{1}, solver.maxSlidingWindow(new int[]{1}, 1));
        assertArrayEquals(new int[]{1, -1}, solver.maxSlidingWindow(new int[]{1, -1}, 1));
        assertArrayEquals(new int[]{11}, solver.maxSlidingWindow(new int[]{9, 11}, 2));
        assertArrayEquals(new int[]{4}, solver.maxSlidingWindow(new int[]{4, -2}, 2));
        assertArrayEquals(new int[]{10, 10, 9, 2}, solver.maxSlidingWindow(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5));
    }
}
