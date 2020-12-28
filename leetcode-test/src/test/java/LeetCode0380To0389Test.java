import com.github.liao47.leetcode.P0389FindTheDifference;
import com.github.liao47.leetcode.P0387FirstUniqueCharacterInAString;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/18 9:16
 */
public class LeetCode0380To0389Test {
    @Test
    public void test0387() {
        P0387FirstUniqueCharacterInAString solver = new P0387FirstUniqueCharacterInAString();
        assertEquals(0, solver.firstUniqChar("leetcode"));
        assertEquals(2, solver.firstUniqChar("loveleetcode"));
        assertEquals(-1, solver.firstUniqChar("aabbccc"));
    }

    @Test
    public void test0389() {
        P0389FindTheDifference solver = new P0389FindTheDifference();

        assertEquals('e', solver.findTheDifference("abcd", "abcde"));
        assertEquals('y', solver.findTheDifference("", "y"));
        assertEquals('a', solver.findTheDifference("a", "aa"));
        assertEquals('a', solver.findTheDifference("ae", "aea"));
        assertEquals('f', solver.findTheDifference("abcde", "abcfde"));
    }
}
