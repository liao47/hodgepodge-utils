import com.github.liao47.leetcode.P0860LemonadeChange;
import com.github.liao47.leetcode.P0861ScoreAfterFlippingMatrix;
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
}
