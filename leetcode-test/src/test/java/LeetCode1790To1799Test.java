import com.github.liao47.leetcode.P1790CheckIfOneStringSwapCanMakeStringsEqual;
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
}
