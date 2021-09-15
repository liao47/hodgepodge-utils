import com.github.liao47.leetcode.P0600NonNegativeIntegersWithoutConsecutiveOnes;
import com.github.liao47.leetcode.P0605CanPlaceFlowers;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author liao47
 * @date 2021/1/4 17:08
 */
public class LeetCode0600To0609Test {
    @Test
    public void test0600() {
        P0600NonNegativeIntegersWithoutConsecutiveOnes solver = new P0600NonNegativeIntegersWithoutConsecutiveOnes();
        Assert.assertEquals(5, solver.findIntegers(5));
    }

    @Test
    public void test0605() {
        P0605CanPlaceFlowers solver = new P0605CanPlaceFlowers();
        assertTrue(solver.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        assertFalse(solver.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        assertTrue(solver.canPlaceFlowers(new int[]{0, 0, 0}, 2));
        assertTrue(solver.canPlaceFlowers(new int[]{1, 0, 1, 0, 1, 0, 1}, 0));
    }
}
