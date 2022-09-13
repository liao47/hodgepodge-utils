import com.github.liao47.leetcode.P0670MaximumSwap;
import com.github.liao47.leetcode.P0673NumberOfLongestIncreasingSubsequence;
import com.github.liao47.leetcode.P0676ImplementMagicDictionary;
import com.github.liao47.leetcode.P0678ValidParenthesisString;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2021/9/13 13:58
 */
public class LeetCode0670To0679Test {
    @Test
    public void test0670() {
        P0670MaximumSwap solver = new P0670MaximumSwap();
        Assert.assertEquals(7236, solver.maximumSwap(2736));
        Assert.assertEquals(9973, solver.maximumSwap(9973));
        Assert.assertEquals(9213, solver.maximumSwap(1293));
        Assert.assertEquals(9913, solver.maximumSwap(1993));
    }

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
    public void test0676() {
        P0676ImplementMagicDictionary.MagicDictionary dictionary = new P0676ImplementMagicDictionary.MagicDictionary();
        dictionary.buildDict(new String[]{"hello", "leetcode"});
        Assert.assertFalse(dictionary.search("hello"));
        Assert.assertTrue(dictionary.search("hhllo"));
        Assert.assertFalse(dictionary.search("hell"));
        Assert.assertFalse(dictionary.search("leetcoded"));
        Assert.assertTrue(dictionary.search("hella"));

        dictionary = new P0676ImplementMagicDictionary.MagicDictionary();
        dictionary.buildDict(new String[]{"hello", "hallo", "leetcode"});
        Assert.assertTrue(dictionary.search("hello"));
        Assert.assertTrue(dictionary.search("hhllo"));
        Assert.assertFalse(dictionary.search("hell"));
        Assert.assertFalse(dictionary.search("leetcoded"));

        dictionary = new P0676ImplementMagicDictionary.MagicDictionary();
        dictionary.buildDict(new String[]{"hello", "hallo", "leetcode", "judge"});
        Assert.assertTrue(dictionary.search("hello"));
        Assert.assertTrue(dictionary.search("hallo"));
        Assert.assertFalse(dictionary.search("hell"));
        Assert.assertTrue(dictionary.search("leetcodd"));
        Assert.assertFalse(dictionary.search("judge"));
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
