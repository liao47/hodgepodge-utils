import com.github.liao47.leetcode.P1790CheckIfOneStringSwapCanMakeStringsEqual;
import com.github.liao47.leetcode.P1792;
import com.github.liao47.leetcode.P1798MaximumNumberOfConsecutiveValuesYouCanMake;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/10/11 9:36
 */
public class LeetCode1790To1799Test {
    @Test
    public void test1790() {
        P1790CheckIfOneStringSwapCanMakeStringsEqual solver = new P1790CheckIfOneStringSwapCanMakeStringsEqual();
        Assert.assertTrue(solver.areAlmostEqual("bank", "kanb"));
        Assert.assertFalse(solver.areAlmostEqual("attack", "defend"));
        Assert.assertTrue(solver.areAlmostEqual("kelb", "kelb"));
        Assert.assertFalse(solver.areAlmostEqual("abcd", "dcba"));
        Assert.assertFalse(solver.areAlmostEqual("aa", "ac"));
    }

    @Test
    public void test1792() {
        P1792 solver = new P1792();
        Assert.assertEquals(0.78333, solver.maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2), 0.00001);
        Assert.assertEquals(0.53485, solver.maxAverageRatio(new int[][]{{2, 4}, {3, 9}, {4, 5}, {2, 10}}, 4), 0.00001);
    }

    @Test
    public void test1798() {
        P1798MaximumNumberOfConsecutiveValuesYouCanMake solver = new P1798MaximumNumberOfConsecutiveValuesYouCanMake();
        Assert.assertEquals(2, solver.getMaximumConsecutive(new int[]{1, 3}));
        Assert.assertEquals(8, solver.getMaximumConsecutive(new int[]{1, 1, 1, 4}));
        Assert.assertEquals(20, solver.getMaximumConsecutive(new int[]{1, 4, 10, 3, 1}));
    }
}
