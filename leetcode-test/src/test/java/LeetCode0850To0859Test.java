import com.github.liao47.leetcode.P0856ScoreOfParentheses;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/10/9 10:41
 */
public class LeetCode0850To0859Test {
    @Test
    public void test0856() {
        P0856ScoreOfParentheses solver = new P0856ScoreOfParentheses();
        Assert.assertEquals(1, solver.scoreOfParentheses("()"));
        Assert.assertEquals(2, solver.scoreOfParentheses("(())"));
        Assert.assertEquals(2, solver.scoreOfParentheses("()()"));
        Assert.assertEquals(6, solver.scoreOfParentheses("(()(()))"));
    }
}
