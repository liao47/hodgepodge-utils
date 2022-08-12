import com.github.liao47.leetcode.P1403MinimumSubsequenceInNonIncreasingOrder;
import com.github.liao47.leetcode.P1408StringMatchingInAnArray;
import org.junit.Assert;
import org.junit.Test;
import util.AssertUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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

    @Test
    public void test1408() {
        P1408StringMatchingInAnArray solver = new P1408StringMatchingInAnArray();
        String[] words = new String[]{"mass", "as", "hero", "superhero"};
        AssertUtils.assertList(Arrays.asList("as", "hero"), solver.stringMatching(words));
        words = new String[]{"leetcode", "et", "code"};
        AssertUtils.assertList(Arrays.asList("et","code"), solver.stringMatching(words));
        words = new String[]{"blue", "green", "bu"};
        AssertUtils.assertList(Collections.emptyList(), solver.stringMatching(words));
    }
}
