import com.github.liao47.leetcode.P0746MinCostClimbingStairs;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/21 9:23
 */
public class LeetCode0740To0749Test {
    @Test
    public void test0746() {
        P0746MinCostClimbingStairs solver = new P0746MinCostClimbingStairs();

        assertEquals(15, solver.minCostClimbingStairs(new int[]{10, 15, 20}));
        assertEquals(6, solver.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        assertEquals(1, solver.minCostClimbingStairs(new int[]{0, 0, 2, 1}));
        assertEquals(8, solver.minCostClimbingStairs(new int[]{1, 100, 2, 1, 2, 100, 1, 1, 100, 1}));
        assertEquals(2, solver.minCostClimbingStairs(new int[]{0, 1, 2, 1}));
        assertEquals(2, solver.minCostClimbingStairs(new int[]{0, 1, 2, 2}));
        assertEquals(2, solver.minCostClimbingStairs(new int[]{1, 2, 2, 0}));
        assertEquals(0, solver.minCostClimbingStairs(new int[]{1, 0, 0, 1}));
    }
}
