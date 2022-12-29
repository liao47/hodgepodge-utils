import com.github.liao47.leetcode.P1754LargestMergeOfTwoStrings;
import com.github.liao47.leetcode.P1759CountNumberOfHomogenousSubstrings;
import com.github.liao47.leetcode.utils.ReadFileUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/12/26 15:35
 */
public class LeetCode1750To1759Test {
    @Test
    public void test1754() {
        P1754LargestMergeOfTwoStrings solver = new P1754LargestMergeOfTwoStrings();
        Assert.assertEquals("cbcabaaaaa", solver.largestMerge("cabaa", "bcaaa"));
        Assert.assertEquals("abdcabcabcaba", solver.largestMerge("abcabc", "abdcaba"));
        Assert.assertEquals("aaaacaaaabaaaaaa", solver.largestMerge("aaaabaaa", "aaaacaaa"));
        Assert.assertEquals("bbaa", solver.largestMerge("ba", "ba"));
        Assert.assertEquals("xyzxyzdcbbaa", solver.largestMerge("xyzdba", "xyzcba"));
    }

    @Test
    public void test1759() {
        P1759CountNumberOfHomogenousSubstrings solver = new P1759CountNumberOfHomogenousSubstrings();
        Assert.assertEquals(13, solver.countHomogenous("abbcccaa"));
        Assert.assertEquals(2, solver.countHomogenous("xy"));
        Assert.assertEquals(15, solver.countHomogenous("zzzzz"));
        Assert.assertEquals(49965, solver.countHomogenous(ReadFileUtils.readString("P1759.txt")));
    }
}
