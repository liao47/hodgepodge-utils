import com.github.liao47.leetcode.P0053MaximumSubarray;
import com.github.liao47.leetcode.P0058LengthOfLastWord;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2021/7/22 15:35
 */
public class LeetCode0050To0059Test {
    @Test
    public void test0053() {
        P0053MaximumSubarray solver = new P0053MaximumSubarray();
        Assert.assertEquals(6, solver.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        Assert.assertEquals(4, solver.maxSubArray(new int[]{2, 1, -2, 3}));
        Assert.assertEquals(1, solver.maxSubArray(new int[]{1}));
        Assert.assertEquals(0, solver.maxSubArray(new int[]{0}));
        Assert.assertEquals(-1, solver.maxSubArray(new int[]{-1}));
        Assert.assertEquals(-100000, solver.maxSubArray(new int[]{-100000}));
        Assert.assertEquals(4, solver.maxSubArray(new int[]{3, -2, -3, -3, 1, 3, 0}));
        Assert.assertEquals(6, solver.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void test0058() {
        P0058LengthOfLastWord solver = new P0058LengthOfLastWord();
        Assert.assertEquals(5, solver.lengthOfLastWord("Hello World"));
        Assert.assertEquals(4, solver.lengthOfLastWord("   fly me   to   the moon  "));
        Assert.assertEquals(6, solver.lengthOfLastWord("luffy is still joyboy"));
        Assert.assertEquals(0, solver.lengthOfLastWord("   "));
    }
}
