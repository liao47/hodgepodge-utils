import com.github.liao47.leetcode.P0160IntersectionOfTwoLinkedLists;
import com.github.liao47.leetcode.P0160IntersectionOfTwoLinkedLists.ListNode;
import com.github.liao47.leetcode.P0162FindPeakElement;
import com.github.liao47.leetcode.P0165CompareVersionNumbers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liaoshiqing
 * @date 2021/7/21 17:28
 */
public class LeetCode0160To0169Test {
    @Test
    public void test0160() {
        P0160IntersectionOfTwoLinkedLists solver = new P0160IntersectionOfTwoLinkedLists();
        ListNode intersection = ListNode.of(8).next(4).next(5).head();
        ListNode headA = ListNode.of(4).next(1).next(intersection).head();
        ListNode headB = ListNode.of(5).next(0).next(1).next(intersection).head();
        Assert.assertSame(intersection, solver.getIntersectionNode(headA, headB));
        Assert.assertSame(intersection, solver.getIntersectionNode2(headA, headB));
        System.out.println(intersection);
        System.out.println(headA);
        System.out.println(headB);

        intersection = ListNode.of(2).next(4).head();
        headA = ListNode.of(0).next(9).next(1).next(intersection).head();
        headB = ListNode.of(3).next(intersection).head();
        Assert.assertSame(intersection, solver.getIntersectionNode(headA, headB));
        Assert.assertSame(intersection, solver.getIntersectionNode2(headA, headB));

        headA = ListNode.of(2).next(6).next(4).head();
        headB = ListNode.of(1).next(5).head();
        Assert.assertNull(solver.getIntersectionNode(headA, headB));
        Assert.assertNull(solver.getIntersectionNode2(headA, headB));
    }

    @Test
    public void test0162() {
        P0162FindPeakElement solver = new P0162FindPeakElement();
        Assert.assertEquals(2, solver.findPeakElement(new int[]{1, 2, 3, 1}));
        Assert.assertTrue(Arrays.asList(1, 5).contains(solver.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4})));
        Assert.assertEquals(0, solver.findPeakElement(new int[]{3, 2, 1}));
        Assert.assertEquals(2, solver.findPeakElement(new int[]{1, 2, 3}));
        Assert.assertEquals(1, solver.findPeakElement(new int[]{1, 2, 1, 0, 1}));
        Assert.assertEquals(3, solver.findPeakElement(new int[]{1, 0, 1, 2, 1}));
        Assert.assertEquals(1, solver.findPeakElement(new int[]{1, 2}));
        Assert.assertEquals(0, solver.findPeakElement(new int[]{2, 1}));
    }

    @Test
    public void test0165() {
        P0165CompareVersionNumbers solver = new P0165CompareVersionNumbers();
        Assert.assertEquals(0, solver.compareVersion("1.01", "1.001"));
        Assert.assertEquals(0, solver.compareVersion("1.0", "1.0.0"));
        Assert.assertEquals(-1, solver.compareVersion("0.1", "1.1"));
        Assert.assertEquals(1, solver.compareVersion("1.0.1", "1"));
        Assert.assertEquals(-1, solver.compareVersion("7.5.2.4", "7.5.3"));
        Assert.assertEquals(1, solver.compareVersion("1.1", "1.0.1"));
        Assert.assertEquals(0, solver.compareVersion("01", "1"));
        Assert.assertEquals(1, solver.compareVersion("1.05", "1.1"));
        Assert.assertEquals(-1, solver.compareVersion("1.2", "1.10"));
    }
}
