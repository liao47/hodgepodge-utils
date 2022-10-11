import com.github.liao47.leetcode.P0927ThreeEqualParts;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/10/11 14:59
 */
public class LeetCode0920To0929Test {
    @Test
    public void test0927() {
        P0927ThreeEqualParts solver = new P0927ThreeEqualParts();
        Assert.assertArrayEquals(new int[]{0, 3}, solver.threeEqualParts(new int[]{1, 0, 1, 0, 1}));
        Assert.assertArrayEquals(new int[]{-1, -1}, solver.threeEqualParts(new int[]{1, 1, 0, 1, 1}));
        Assert.assertArrayEquals(new int[]{0, 2}, solver.threeEqualParts(new int[]{1, 1, 0, 0, 1}));
        Assert.assertArrayEquals(new int[]{0, 4}, solver.threeEqualParts(new int[]{0, 0, 0, 0, 0}));
        Assert.assertArrayEquals(new int[]{0, 2}, solver.threeEqualParts(new int[]{1, 1, 1}));
    }
}
