import com.github.liao47.leetcode.P1221SplitAStringInBalancedStrings;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2021/9/7 14:48
 */
public class LeetCode1220To1229Test {
    @Test
    public void test1221() {
        P1221SplitAStringInBalancedStrings solver = new P1221SplitAStringInBalancedStrings();
        Assert.assertEquals(4, solver.balancedStringSplit("RLRRLLRLRL"));
        Assert.assertEquals(3, solver.balancedStringSplit("RLLLLRRRLR"));
        Assert.assertEquals(1, solver.balancedStringSplit("LLLLRRRR"));
        Assert.assertEquals(2, solver.balancedStringSplit("RLRRRLLRLL"));
    }
}
