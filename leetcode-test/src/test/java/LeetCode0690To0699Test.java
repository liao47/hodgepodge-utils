import com.github.liao47.leetcode.P0698PartitionToKEqualSumSubsets;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/9/20 10:15
 */
public class LeetCode0690To0699Test {
    @Test
    public void test0698() {
        P0698PartitionToKEqualSumSubsets solver = new P0698PartitionToKEqualSumSubsets();
        Assert.assertTrue(solver.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        Assert.assertFalse(solver.canPartitionKSubsets(new int[]{1, 2, 3, 4}, 3));
        Assert.assertFalse(solver.canPartitionKSubsets(new int[]{2, 2, 2, 2, 3, 4, 5}, 4));
    }
}
