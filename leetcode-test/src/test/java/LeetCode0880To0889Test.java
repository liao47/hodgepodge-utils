import com.github.liao47.leetcode.P0886PossibleBipartition;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/10/17 15:41
 */
public class LeetCode0880To0889Test {
    @Test
    public void test0886() {
        P0886PossibleBipartition solver = new P0886PossibleBipartition();
        Assert.assertTrue(solver.possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
        Assert.assertFalse(solver.possibleBipartition(3, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        Assert.assertFalse(solver.possibleBipartition(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}));
        Assert.assertTrue(solver.possibleBipartition(4, new int[][]{{1, 4}, {2, 3}, {1, 2}}));
        Assert.assertTrue(solver.possibleBipartition(1, new int[0][0]));
        Assert.assertTrue(solver.possibleBipartition(5, new int[][]{{1, 4}, {2, 3}, {2, 5}, {4, 5}}));
        Assert.assertTrue(solver.possibleBipartition(10, new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}}));
    }
}
