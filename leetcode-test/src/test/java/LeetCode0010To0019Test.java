import com.github.liao47.leetcode.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    @Test
    public void test0012() {
        P0012IntegerToRoman solver = new P0012IntegerToRoman();
        Assert.assertEquals("III", solver.intToRoman(3));
        Assert.assertEquals("IV", solver.intToRoman(4));
        Assert.assertEquals("IX", solver.intToRoman(9));
        Assert.assertEquals("LVIII", solver.intToRoman(58));
        Assert.assertEquals("MCMXCIV", solver.intToRoman(1994));
    }

    @Test
    public void test0013() {
        P0013RomanToInteger solver = new P0013RomanToInteger();
        //Assert.assertEquals(3, solver.romanToInt("III"));
        Assert.assertEquals(4, solver.romanToInt("IV"));
        Assert.assertEquals(9, solver.romanToInt("IX"));
        Assert.assertEquals(58, solver.romanToInt("LVIII"));
        Assert.assertEquals(1994, solver.romanToInt("MCMXCIV"));
    }

    @Test
    public void test0014() {
        P0014LongestCommonPrefix solver = new P0014LongestCommonPrefix();
        Assert.assertEquals("fl", solver.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        Assert.assertEquals("", solver.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        Assert.assertEquals("", solver.longestCommonPrefix(new String[]{""}));
        Assert.assertEquals("a", solver.longestCommonPrefix(new String[]{"a"}));
        Assert.assertEquals("a", solver.longestCommonPrefix(new String[]{"ab", "a"}));
    }

    @Test
    public void test0015() {
        P0015ThreeSum solver = new P0015ThreeSum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1));
        Assert.assertEquals(list, solver.threeSum(nums));

        nums = new int[0];
        list = new ArrayList<>();
        Assert.assertEquals(list, solver.threeSum(nums));

        nums = new int[]{0};
        Assert.assertEquals(list, solver.threeSum(nums));

        nums = new int[]{0, 0, 0, 0, 0, 0};
        list = Collections.singletonList(Arrays.asList(0, 0, 0));
        Assert.assertEquals(list, solver.threeSum(nums));
    }

    @Test
    public void test0016() {
        P0016ThreeSumClosest solver = new P0016ThreeSumClosest();
        Assert.assertEquals(2, solver.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        Assert.assertEquals(0, solver.threeSumClosest(new int[]{0, 0, 0}, 1));
        Assert.assertEquals(3, solver.threeSumClosest(new int[]{0, 1, 2}, 0));
        Assert.assertEquals(3, solver.threeSumClosest(new int[]{1, 1, 1, 1}, 4));
    }
}
