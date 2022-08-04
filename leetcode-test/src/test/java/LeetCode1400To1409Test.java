import com.github.liao47.leetcode.P1403MinimumSubsequenceInNonIncreasingOrder;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author liaoshiqing
 * @date 2022/8/4 9:17
 */
public class LeetCode1400To1409Test {
    @Test
    public void test1403() {
        P1403MinimumSubsequenceInNonIncreasingOrder solver = new P1403MinimumSubsequenceInNonIncreasingOrder();
        Assert.assertEquals(Arrays.asList(10, 9), solver.minSubsequence(new int[]{4, 3, 10, 9, 8}));
        Assert.assertEquals(Arrays.asList(7, 7, 6), solver.minSubsequence(new int[]{4, 4, 7, 6, 7}));
        Assert.assertEquals(Collections.singletonList(6), solver.minSubsequence(new int[]{6}));
    }
}
