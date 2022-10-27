import com.github.liao47.leetcode.P0860LemonadeChange;
import com.github.liao47.leetcode.P0861ScoreAfterFlippingMatrix;
import com.github.liao47.leetcode.P0862ShortestSubarrayWithSumAtLeastK;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author liao47
 * @date 2020/12/10 9:43
 */
public class LeetCode0860To0869Test {

    @Test
    public void test0860() {
        P0860LemonadeChange solver = new P0860LemonadeChange();
        int[] bills = {5, 5, 5, 10, 20};
        assertTrue(solver.lemonadeChange(bills));

        bills = new int[]{5, 5, 10};
        assertTrue(solver.lemonadeChange(bills));

        bills = new int[]{10, 10};
        assertFalse(solver.lemonadeChange(bills));

        bills = new int[]{5, 5, 10, 10, 20};
        assertFalse(solver.lemonadeChange(bills));

        bills = new int[0];
        assertTrue(solver.lemonadeChange(bills));
    }

    @Test
    public void test0861() {
        P0861ScoreAfterFlippingMatrix solver = new P0861ScoreAfterFlippingMatrix();

        int[][] arr = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        assertEquals(39, solver.matrixScore(arr));
        arr = new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}, {1, 0, 0, 1}};
        assertEquals(49, solver.matrixScore(arr));

        arr = new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        assertEquals(39, solver.matrixScore2(arr));
        arr = new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}, {1, 0, 0, 1}};
        assertEquals(49, solver.matrixScore2(arr));
    }

    @Test
    public void test0862() {
        P0862ShortestSubarrayWithSumAtLeastK solver = new P0862ShortestSubarrayWithSumAtLeastK();
        Assert.assertEquals(1, solver.shortestSubarray(new int[]{-100, 1, 2}, 2));
        Assert.assertEquals(1, solver.shortestSubarray(new int[]{1}, 1));
        Assert.assertEquals(-1, solver.shortestSubarray(new int[]{1, 2}, 4));
        Assert.assertEquals(3, solver.shortestSubarray(new int[]{2, -1, 2}, 3));
        Assert.assertEquals(3, solver.shortestSubarray(new int[]{1, 2, -1, 3}, 4));
        Assert.assertEquals(3, solver.shortestSubarray(new int[]{5, 2, -3, 4, 6, 1}, 11));
        Assert.assertEquals(1, solver.shortestSubarray(new int[]{2, -1, -3, 8, 2}, 6));
        Assert.assertEquals(3, solver.shortestSubarray(new int[]{2, -1, 1, 8, 1}, 10));
        Assert.assertEquals(3, solver.shortestSubarray(new int[]{84, -37, 32, 40, 95}, 167));
        Assert.assertEquals(3, solver.shortestSubarray(new int[]{-28, 81, -20, 28, -29}, 89));
        Assert.assertEquals(3, solver.shortestSubarray(new int[]{-47, 45, 92, 86, 17, -22, 77, 62, -1, 42}, 180));
        Assert.assertEquals(2, solver.shortestSubarray(new int[]{-34, 37, 51, 3, -12, -50, 51, 100, -47, 99,
                34, 14, -13, 89, 31, -14, -44, 23, -38, 6}, 151));
    }
}
