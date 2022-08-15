import com.github.liao47.leetcode.P1422MaximumScoreAfterSplittingAString;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/8/15 15:39
 */
public class LeetCode1420To1429Test {
    @Test
    public void test1422() {
        P1422MaximumScoreAfterSplittingAString solver = new P1422MaximumScoreAfterSplittingAString();
        Assert.assertEquals(5, solver.maxScore("011101"));
        Assert.assertEquals(5, solver.maxScore("00111"));
        Assert.assertEquals(3, solver.maxScore("1111"));
        Assert.assertEquals(1, solver.maxScore("00"));
        Assert.assertEquals(3, solver.maxScore("001"));
        Assert.assertEquals(2, solver.maxScore("0100"));
        Assert.assertEquals(60, solver.maxScore("110000000000000000000000000011111110101010111111111111111111111111"));
    }
}
