import com.github.liao47.leetcode.P0583DeleteOperationForTwoStrings;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2021/9/26 16:09
 */
public class LeetCode0580To0589Test {
    @Test
    public void test0583() {
        P0583DeleteOperationForTwoStrings solver = new P0583DeleteOperationForTwoStrings();
        Assert.assertEquals(2, solver.minDistance("sea", "eat"));
    }
}
