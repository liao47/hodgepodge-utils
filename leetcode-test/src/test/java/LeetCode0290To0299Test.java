import com.github.liao47.leetcode.LeetCode0290;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author liaoshiqing
 * @date 2020/12/16 15:07
 */
public class LeetCode0290To0299Test {
    @Test
    public void test0290() {
        LeetCode0290 solver = new LeetCode0290();

        assertTrue(solver.wordPattern("abba", "dog cat cat dog"));
        assertFalse(solver.wordPattern("abba", "dog cat cat fish"));
        assertFalse(solver.wordPattern("aaaa", "dog cat cat dog"));
        assertFalse(solver.wordPattern("abba", "dog dog dog dog"));
        assertTrue(solver.wordPattern("abc", "b c a"));

        assertTrue(solver.wordPattern2("abba", "dog cat cat dog"));
        assertFalse(solver.wordPattern2("abba", "dog cat cat fish"));
        assertFalse(solver.wordPattern2("aaaa", "dog cat cat dog"));
        assertFalse(solver.wordPattern2("abba", "dog dog dog dog"));
        assertTrue(solver.wordPattern2("abc", "b c a"));
        assertFalse(solver.wordPattern2("abc", "dog cat dog"));
    }
}
