import com.github.liao47.leetcode.P0384ShuffleAnArray;
import com.github.liao47.leetcode.P0389FindTheDifference;
import com.github.liao47.leetcode.P0387FirstUniqueCharacterInAString;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/18 9:16
 */
public class LeetCode0380To0389Test {
    @Test
    public void test0384() {
        P0384ShuffleAnArray.Solution solution = new P0384ShuffleAnArray.Solution(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(solution.shuffle()));
        Assert.assertArrayEquals(new int[]{1, 2, 3}, solution.reset());
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }

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
