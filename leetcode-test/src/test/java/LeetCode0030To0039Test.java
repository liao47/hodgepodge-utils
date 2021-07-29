import com.github.liao47.leetcode.P0034FindFirstAndLastPositionOfElementInSortedArray;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2021/7/23 14:23
 */
public class LeetCode0030To0039Test {
    @Test
    public void test0034() {
        P0034FindFirstAndLastPositionOfElementInSortedArray solver =
                new P0034FindFirstAndLastPositionOfElementInSortedArray();
        Assert.assertArrayEquals(new int[]{3, 4}, solver.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        Assert.assertArrayEquals(new int[]{-1, -1}, solver.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
        Assert.assertArrayEquals(new int[]{-1, -1}, solver.searchRange(new int[]{}, 0));
        Assert.assertArrayEquals(new int[]{0, 0}, solver.searchRange(new int[]{1}, 1));
        Assert.assertArrayEquals(new int[]{1, 5}, solver.searchRange(new int[]{1, 2, 2, 2, 2, 2, 3}, 2));

        Assert.assertEquals(2, solver.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        Assert.assertEquals(0, solver.search(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }
}
