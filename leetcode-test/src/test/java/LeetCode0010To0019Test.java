import com.github.liao47.leetcode.LeetCode0010_timeout;
import com.github.liao47.leetcode.LeetCode0010_2;
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
        LeetCode0010_timeout solver = new LeetCode0010_timeout();

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
        LeetCode0010_2 solver = new LeetCode0010_2();

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
}
