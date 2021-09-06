import com.github.liao47.leetcode.P0704BinarySearch;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2021/9/6 9:44
 */
public class LeetCode0700To0709Test {
    @Test
    public void test0704() {
        P0704BinarySearch solver = new P0704BinarySearch();
        Assert.assertEquals(4, solver.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        Assert.assertEquals(-1, solver.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        Assert.assertEquals(0, solver.search(new int[]{5}, 5));
    }
}
