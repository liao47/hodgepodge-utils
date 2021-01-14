import com.github.liao47.leetcode.P0188BestTimeToBuyAndSellStockIV;
import com.github.liao47.leetcode.P0189RotateArray;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/28 9:27
 */
public class LeetCode0180To0189Test {
    @Test
    public void test0188() {
        P0188BestTimeToBuyAndSellStockIV solver = new P0188BestTimeToBuyAndSellStockIV();
        assertEquals(2, solver.maxProfit(2, new int[]{2, 4, 1}));
        assertEquals(7, solver.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
        assertEquals(4, solver.maxProfit(1, new int[]{2, 5, 3, 6, 1}));
        assertEquals(10, solver.maxProfit(2, new int[]{1, 3, 5, 4, 3, 7, 6, 9, 2, 4}));
        assertEquals(5, solver.maxProfit(1, new int[]{6, 1, 6, 4, 3, 0, 2}));
        assertEquals(3, solver.maxProfit(2, new int[]{1, 2, 4}));
        assertEquals(0, solver.maxProfit(1, new int[]{2, 1}));
        assertEquals(6, solver.maxProfit(2, new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        assertEquals(17, solver.maxProfit(2, new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9}));
        assertEquals(11, solver.maxProfit(2, new int[]{0, 8, 5, 7, 4, 7}));
        assertEquals(12, solver.maxProfit(2, new int[]{5, 5, 4, 9, 3, 8, 5, 5, 1, 6, 8, 3, 4}));
        assertEquals(16, solver.maxProfit(2, new int[]{1, 9, 6, 9, 1, 7, 1, 1, 5, 9, 9, 9}));
        assertEquals(12, solver.maxProfit(2, new int[]{5, 2, 3, 0, 3, 5, 6, 8, 1, 5}));
        assertEquals(13, solver.maxProfit(2, new int[]{3, 5, 3, 4, 1, 4, 5, 0, 7, 8, 5, 6, 9, 4, 1}));
    }

    @Test
    public void test0189() {
        P0189RotateArray solver = new P0189RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solver.rotate(nums, 3);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums);

        nums = new int[]{-1, -100, 3, 99};
        solver.rotate(nums, 2);
        assertArrayEquals(new int[]{3, 99, -1, -100}, nums);

        nums = new int[]{1, 2, 3, 4, 5, 6};
        solver.rotate(nums, 4);
        assertArrayEquals(new int[]{3, 4, 5, 6, 1, 2}, nums);

        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        solver.rotate(nums, 1);
        assertArrayEquals(new int[]{7, 1, 2, 3, 4, 5, 6}, nums);

        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        solver.rotate(nums, 4);
        assertArrayEquals(new int[]{5, 6, 7, 8, 1, 2, 3, 4}, nums);
    }
}
