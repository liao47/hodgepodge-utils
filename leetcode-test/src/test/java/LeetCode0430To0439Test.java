import com.github.liao47.leetcode.P0435NonOverlappingIntervals;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2021/1/8 16:28
 */
public class LeetCode0430To0439Test {
    @Test
    public void test0435() {
        P0435NonOverlappingIntervals solver = new P0435NonOverlappingIntervals();
        assertEquals(1, solver.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        assertEquals(2, solver.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        assertEquals(0, solver.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
        assertEquals(2, solver.eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}));
        assertEquals(2, solver.eraseOverlapIntervals(new int[][]{{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}}));
    }
}
