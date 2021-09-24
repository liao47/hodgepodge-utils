import com.github.liao47.leetcode.P0673NumberOfLongestIncreasingSubsequence;
import com.github.liao47.leetcode.P0678ValidParenthesisString;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2021/9/13 13:58
 */
public class LeetCode0670To0679Test {
    @Test
    public void test0673() {
        P0673NumberOfLongestIncreasingSubsequence solver = new P0673NumberOfLongestIncreasingSubsequence();
        Assert.assertEquals(2, solver.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        Assert.assertEquals(2, solver.findNumberOfLIS(new int[]{1, 8, 7, 4, 5, 6, 2, 3, 4}));
        Assert.assertEquals(5, solver.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
        Assert.assertEquals(5, solver.findNumberOfLIS(new int[]{5, 4, 3, 2, 1}));
        Assert.assertEquals(27, solver.findNumberOfLIS(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3}));
        Assert.assertEquals(10, solver.findNumberOfLIS1(new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3}));
    }

    @Test
    public void test0678() {
        P0678ValidParenthesisString solver = new P0678ValidParenthesisString();
        Assert.assertTrue(solver.checkValidString("()"));
        Assert.assertTrue(solver.checkValidString("(*)"));
        Assert.assertTrue(solver.checkValidString("(*))"));
        Assert.assertTrue(solver.checkValidString("(((*))"));
        Assert.assertFalse(solver.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
        Assert.assertTrue(solver.checkValidString("(((*))"));
        Assert.assertFalse(solver.checkValidString("****((("));
        Assert.assertTrue(solver.checkValidString("((()))()(())(*()()())**(())()()()()((*()*))((*()*)"));
    }
}
