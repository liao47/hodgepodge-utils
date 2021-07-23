import com.github.liao47.leetcode.P1893CheckIfAllTheIntegersInARangeAreCovered;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2021/7/23 9:58
 */
public class LeetCode1890To1899Test {
    @Test
    public void test1893() {
        P1893CheckIfAllTheIntegersInARangeAreCovered solver = new P1893CheckIfAllTheIntegersInARangeAreCovered();
        Assert.assertTrue(solver.isCovered(new int[][]{{1, 2}, {3, 4}, {5, 6}}, 2, 5));
        Assert.assertFalse(solver.isCovered(new int[][]{{1, 10}, {10, 20}}, 21, 21));
        Assert.assertTrue(solver.isCovered(new int[][]{{2, 2}, {3, 3}, {1, 1}}, 1, 3));
    }
}
