import com.github.liao47.leetcode.P1877MinimizeMaximumPairSumInArray;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2021/7/20 10:04
 */
public class LeetCode1870To1879Test {

    @Test
    public void test1877() {
        P1877MinimizeMaximumPairSumInArray solver = new P1877MinimizeMaximumPairSumInArray();
        Assert.assertEquals(7, solver.minPairSum(new int[]{3, 5, 2, 3}));
        Assert.assertEquals(8, solver.minPairSum(new int[]{3, 5, 4, 2, 4, 6}));

        Assert.assertEquals(7, solver.minPairSum2(new int[]{3, 5, 2, 3}));
        Assert.assertEquals(8, solver.minPairSum2(new int[]{3, 5, 4, 2, 4, 6}));
    }
}
