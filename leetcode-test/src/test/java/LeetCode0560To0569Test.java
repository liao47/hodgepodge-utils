import com.github.liao47.leetcode.P0565ArrayNesting;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/7/18 17:00
 */
public class LeetCode0560To0569Test {
    @Test
    public void test0565() {
        P0565ArrayNesting solver = new P0565ArrayNesting();
        Assert.assertEquals(4, solver.arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
        Assert.assertEquals(1, solver.arrayNesting(new int[]{0, 1, 2}));
    }
}
