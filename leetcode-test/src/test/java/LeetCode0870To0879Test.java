import com.github.liao47.leetcode.P0870AdvantageShuffle;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/10/9 15:04
 */
public class LeetCode0870To0879Test {
    @Test
    public void test0870() {
        P0870AdvantageShuffle solver = new P0870AdvantageShuffle();
        Assert.assertArrayEquals(new int[]{2, 11, 7, 15}, solver.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1,
                10, 4, 11}));
        Assert.assertArrayEquals(new int[]{24, 32, 8, 12}, solver.advantageCount(new int[]{12, 24, 8, 32},
                new int[]{13, 25, 32, 11}));
    }
}
