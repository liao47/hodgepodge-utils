import com.github.liao47.leetcode.P0593ValidSquare;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/8/1 10:57
 */
public class LeetCode0590To0599Test {
    @Test
    public void test0593() {
        P0593ValidSquare solver = new P0593ValidSquare();
        Assert.assertTrue(solver.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}));
        Assert.assertFalse(solver.validSquare(new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0}));
        Assert.assertTrue(solver.validSquare(new int[]{0, 0}, new int[]{2, 2}, new int[]{0, 2}, new int[]{2, 0}));
    }
}
