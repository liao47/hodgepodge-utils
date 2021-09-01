import com.github.liao47.leetcode.P0010RegularExpressionMatching_timeout;
import com.github.liao47.leetcode.P0010RegularExpressionMatching;
import com.github.liao47.leetcode.P0011ContainerWithMostWater;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author liao47
 * @date 2020/12/12 14:42
 */
public class LeetCode0010To0019Test {
    @Test
    public void test0010() {
        P0010RegularExpressionMatching_timeout solver = new P0010RegularExpressionMatching_timeout();

        assertFalse(solver.isMatch("aa", "a"));
        assertTrue(solver.isMatch("aa", "a*"));
        assertTrue(solver.isMatch("ab", ".*"));
        assertTrue(solver.isMatch("aab", "c*a*b"));
        assertFalse(solver.isMatch("mississippi", "mis*is*p*."));
        assertTrue(solver.isMatch("abcdefghijkabcokabc", "ab.*abc.*abc"));
        assertFalse(solver.isMatch("ab", ".*c"));
        assertTrue(solver.isMatch("a", "ab*"));
        assertTrue(solver.isMatch("bbbba", ".*a*a"));
        assertFalse(solver.isMatch("aaa", "aaaa"));
        assertTrue(solver.isMatch("", "c*"));
    }

    @Test
    public void test0010_2() {
        P0010RegularExpressionMatching solver = new P0010RegularExpressionMatching();

        assertFalse(solver.isMatch("aa", "a"));
        assertTrue(solver.isMatch("aa", "a*"));
        assertTrue(solver.isMatch("ab", ".*"));
        assertTrue(solver.isMatch("aab", "c*a*b"));
        assertFalse(solver.isMatch("mississippi", "mis*is*p*."));
        assertTrue(solver.isMatch("abcdefghijkabcokabc", "ab.*abc.*abc"));
        assertFalse(solver.isMatch("ab", ".*c"));
        assertTrue(solver.isMatch("a", "ab*"));
        assertTrue(solver.isMatch("bbbba", ".*a*a"));
        assertFalse(solver.isMatch("aaa", "aaaa"));
        assertTrue(solver.isMatch("", "c*"));
        assertTrue(solver.isMatch("baabbbaccbccacacc", "c*..b*a*a.*a..*c"));
        assertTrue(solver.isMatch("a", "b*a*a"));
    }

    @Test
    public void test0011() {
        P0011ContainerWithMostWater solver = new P0011ContainerWithMostWater();
        Assert.assertEquals(49, solver.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        Assert.assertEquals(1, solver.maxArea(new int[]{1, 1}));
        Assert.assertEquals(16, solver.maxArea(new int[]{4, 3, 2, 1, 4}));
        Assert.assertEquals(2, solver.maxArea(new int[]{1, 2, 1}));
    }
}
