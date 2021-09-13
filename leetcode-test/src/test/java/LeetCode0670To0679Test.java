import com.github.liao47.leetcode.P0678ValidParenthesisString;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2021/9/13 13:58
 */
public class LeetCode0670To0679Test {
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
