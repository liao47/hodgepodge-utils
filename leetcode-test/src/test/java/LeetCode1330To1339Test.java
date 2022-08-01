import com.github.liao47.leetcode.P1331RankTransformOfAnArray;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/7/29 13:47
 */
public class LeetCode1330To1339Test {
    @Test
    public void test1331() {
        P1331RankTransformOfAnArray solver = new P1331RankTransformOfAnArray();
        Assert.assertArrayEquals(new int[]{4, 1, 2, 3}, solver.arrayRankTransform(new int[]{40, 10, 20, 30}));
        Assert.assertArrayEquals(new int[]{1, 1, 1}, solver.arrayRankTransform(new int[]{100, 100, 100}));
        Assert.assertArrayEquals(new int[]{5, 3, 4, 2, 8, 6, 7, 1, 3}, solver.arrayRankTransform(new int[]{37, 12, 28
                , 9, 100, 56, 80, 5, 12}));
    }
}
