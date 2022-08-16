import com.github.liao47.leetcode.P0768MaxChunksToMakeSortedII;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/8/16 14:01
 */
public class LeetCode0760To0769Test {
    @Test
    public void test0768() {
        P0768MaxChunksToMakeSortedII solver = new P0768MaxChunksToMakeSortedII();
        Assert.assertEquals(1, solver.maxChunksToSorted(new int[]{5, 4, 3, 2, 1}));
        Assert.assertEquals(4, solver.maxChunksToSorted(new int[]{2, 1, 3, 4, 4}));
    }
}
