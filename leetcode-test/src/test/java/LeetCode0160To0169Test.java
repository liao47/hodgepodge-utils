import com.github.liao47.leetcode.P0160IntersectionOfTwoLinkedLists;
import com.github.liao47.leetcode.P0160IntersectionOfTwoLinkedLists.ListNode;
import org.junit.Assert;
import org.junit.Test;

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
}