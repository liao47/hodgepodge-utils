import com.github.liao47.leetcode.P0725SplitLinkedListInParts;
import com.github.liao47.leetcode.P0725SplitLinkedListInParts.ListNode;
import com.github.liao47.leetcode.P0729MyCalendarI;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liaoshiqing
 * @date 2021/9/22 14:00
 */
public class LeetCode0720To0729Test {
    @Test
    public void test0725() {
        P0725SplitLinkedListInParts solver = new P0725SplitLinkedListInParts();

        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3)));
    //    Assert.assertEquals("[[1], [2], [3], null, null]", Arrays.toString(solver.splitListToParts(node, 5)));

        node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10))))))))));
        Assert.assertEquals("[[1,2,3,4], [5,6,7], [8,9,10]]", Arrays.toString(solver.splitListToParts(node, 3)));
    }

    @Test
    public void test0729() {
        P0729MyCalendarI.MyCalendar myCalendar = new P0729MyCalendarI.MyCalendar();
        Assert.assertTrue(myCalendar.book(10, 20));
        Assert.assertFalse(myCalendar.book(15, 25));
        Assert.assertTrue(myCalendar.book(20, 30));

        myCalendar = new P0729MyCalendarI.MyCalendar();
        Assert.assertTrue(myCalendar.book(1, 3));
        Assert.assertFalse(myCalendar.book(2, 4));
        Assert.assertTrue(myCalendar.book(5, 8));
        Assert.assertFalse(myCalendar.book(4, 6));

        myCalendar = new P0729MyCalendarI.MyCalendar();
        Assert.assertTrue(myCalendar.book(47, 50));
        Assert.assertTrue(myCalendar.book(33, 41));
        Assert.assertFalse(myCalendar.book(39, 45));
        Assert.assertFalse(myCalendar.book(33, 42));
        Assert.assertTrue(myCalendar.book(25, 32));
        Assert.assertFalse(myCalendar.book(26, 35));
        Assert.assertTrue(myCalendar.book(19, 25));
        Assert.assertTrue(myCalendar.book(3, 8));
        Assert.assertTrue(myCalendar.book(8, 13));
        Assert.assertFalse(myCalendar.book(18, 27));

        myCalendar = new P0729MyCalendarI.MyCalendar();
        Assert.assertTrue(myCalendar.book(23, 32));
        Assert.assertTrue(myCalendar.book(42, 50));
        Assert.assertTrue(myCalendar.book(6, 14));
        Assert.assertFalse(myCalendar.book(0, 7));

        myCalendar = new P0729MyCalendarI.MyCalendar();
        Assert.assertTrue(myCalendar.book(1, 2));
        Assert.assertTrue(myCalendar.book(0, 1));
    }
}
