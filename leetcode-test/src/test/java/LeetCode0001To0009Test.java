import com.github.liao47.leetcode.*;
import com.github.liao47.leetcode.LeetCode0002.ListNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author liao47
 * @date 2020/12/3 16:43
 */
public class LeetCode0001To0009Test {
    @Test
    public void test0001() {
        LeetCode0001 solver = new LeetCode0001();
        int[] arr = {2, 7, 11, 15};
        assertEquals("[0, 1]", Arrays.toString(solver.twoSum(arr, 9)));
        assertEquals("[0, 1]", Arrays.toString(solver.twoSum2(arr, 9)));
        assertEquals("[0, 1]", Arrays.toString(solver.twoSum3(arr, 9)));
        assertEquals("[0, 1]", Arrays.toString(solver.twoSum4(arr, 9)));
    }

    @Test
    public void test0002() {
        LeetCode0002 solver = new LeetCode0002();
        assertEquals("807", solver.addTwoNumbers(ListNode.of("342"), ListNode.of("465")).toString());
        assertEquals("807", solver.addTwoNumbers2(ListNode.of("342"), ListNode.of("465")).toString());
    }

    @Test
    public void test0003() {
        LeetCode0003 solver = new LeetCode0003();
        assertEquals(3, solver.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, solver.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, solver.lengthOfLongestSubstring("pwwkew"));
        assertEquals(0, solver.lengthOfLongestSubstring(""));

        assertEquals(3, solver.lengthOfLongestSubstring2("abcabcbb"));
        assertEquals(1, solver.lengthOfLongestSubstring2("bbbbb"));
        assertEquals(3, solver.lengthOfLongestSubstring2("pwwkew"));
        assertEquals(0, solver.lengthOfLongestSubstring2(""));
    }

    @Test
    public void test0004() {
        LeetCode0004 solver = new LeetCode0004();
        assertEquals(2, solver.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 0.00000);
        assertEquals(2.5, solver.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 0.00000);
        assertEquals(0, solver.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}), 0.00000);
        assertEquals(1, solver.findMedianSortedArrays(new int[]{}, new int[]{1}), 0.00000);
        assertEquals(2, solver.findMedianSortedArrays(new int[]{2}, new int[]{}), 0.00000);
    }

    @Test
    public void test0005() {
        LeetCode0005 solver = new LeetCode0005();
        assertEquals("bab", solver.longestPalindrome("babad"));
        assertEquals("bb", solver.longestPalindrome("cbbd"));
    }

    @Test
    public void test0006() {
        LeetCode0006 solver = new LeetCode0006();
        assertEquals("LCIRETOESIIGEDHN", solver.convert("LEETCODEISHIRING", 3));
        assertEquals("LDREOEIIECIHNTSG", solver.convert("LEETCODEISHIRING", 4));
        assertEquals("AB", solver.convert("AB", 1));
    }

    @Test
    public void test0007() {
        LeetCode0007 solver = new LeetCode0007();
        System.out.println(solver.reverse(123));
        System.out.println(solver.reverse(789));
        assertEquals(987654321, solver.reverse(1234567890));
    }

    @Test
    public void test0008() {
        LeetCode0008 solver = new LeetCode0008();
        assertEquals(42, solver.myAtoi("42"));
        assertEquals(-42, solver.myAtoi("   -42"));
        assertEquals(4193, solver.myAtoi("4193 with words"));
        assertEquals(0, solver.myAtoi("words and 987"));
        assertEquals(Integer.MIN_VALUE, solver.myAtoi("-91283472332"));
        assertEquals(Integer.MAX_VALUE, solver.myAtoi("9223372036854775808"));
        assertEquals(0, solver.myAtoi(" "));
    }

    @Test
    public void test0009() {
        LeetCode0009 solver = new LeetCode0009();
        assertTrue(solver.isPalindrome(121));
        assertFalse(solver.isPalindrome(-121));
        assertFalse(solver.isPalindrome(10));

        assertTrue(solver.isPalindrome2(121));
        assertFalse(solver.isPalindrome2(-121));
        assertFalse(solver.isPalindrome2(10));

        assertTrue(solver.isPalindrome3(121));
        assertFalse(solver.isPalindrome3(-121));
        assertFalse(solver.isPalindrome3(10));
    }
}
