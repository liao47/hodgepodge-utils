package test;

import com.github.liao47.leetcode.OII091;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/6/28 16:56
 */
public class OfferII090To099Test {
    @Test
    public void test091() {
        OII091 solver = new OII091();
        int[][] costs = new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        Assert.assertEquals(10, solver.minCost(costs));

        costs = new int[][]{{7, 6, 2}};
        Assert.assertEquals(2, solver.minCost(costs));

        costs = new int[][]{{7, 1, 7}, {8, 8, 2}, {20, 20, 1}};
        Assert.assertEquals(10, solver.minCost(costs));
    }
}
