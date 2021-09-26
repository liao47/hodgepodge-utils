import com.github.liao47.leetcode.P1143LongestCommonSubsequence;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2021/9/26 15:39
 */
public class LeetCode1140To1149Test {
    @Test
    public void test1143() {
        P1143LongestCommonSubsequence solver = new P1143LongestCommonSubsequence();
        Assert.assertEquals(3, solver.longestCommonSubsequence("abcde", "ace"));
        Assert.assertEquals(3, solver.longestCommonSubsequence("abc", "abc"));
        Assert.assertEquals(0, solver.longestCommonSubsequence("abc", "def"));
    }
}
